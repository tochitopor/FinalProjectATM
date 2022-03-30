package ru.tochitopor.atm.client.controller;

import lombok.extern.java.Log;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.tochitopor.atm.common.Request;
import ru.tochitopor.atm.common.ResponseDTO;
import ru.tochitopor.atm.common.RequestTypes;
import ru.tochitopor.atm.client.service.ClientService;

@RequestMapping("/ATM")
@RestController
@Log
public class ClientController {
    private RestTemplate restTemplate = new RestTemplate();
    private ClientService clientService;
    private final String LOCAL_HOST = "http://127.0.0.1:8082";

    @GetMapping()
    public String getHostsInfo() {
        return "Russian Moscow ATM Test 8081";
    }

    @GetMapping("/clients/{clientId}/scores/{scoreId}/{PIN}")
    public int getClientBalance(
            @PathVariable("clientId") Long clientId,
            @PathVariable("scoreId") Long scoreId,
            @PathVariable("PIN") int PIN) {

        log.info("clientId " + clientId + " accountId " + scoreId + " PIN " + PIN);

        //"{\"clientId\":1,\"accountId\":0,\"pin\":123}";
        String requestString = "{\"clientId\":" + clientId + ",\"scoreId\":" + scoreId + ",\"pin\":" + PIN + "}";
        HttpEntity<Request> request = new HttpEntity<>(new Request(1, requestString, RequestTypes.JSON));

        log.info("request.toString()" + request.toString());

        /*ResponseEntity<String> responseEntityStr = restTemplate.
                postForEntity("http://127.0.0.1:8080/host/clients" + clientId + "/getBalance",
                        request, String.class);

        log.info("responseEntityStr.getBody()" + responseEntityStr.getBody());*/

        ResponseDTO response = restTemplate.postForObject(
                LOCAL_HOST + "/host/clients/"+ clientId, request, ResponseDTO.class);

        log.info("responseEntityStr.getBody()" + response.getBalance());

        return clientService.getClientBalance(response);
    }
}
