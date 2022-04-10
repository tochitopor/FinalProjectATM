package ru.tochitopor.atm.client.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
/*import ru.tochitopor.atm.common.Request;
import ru.tochitopor.atm.common.ResponseDTO;
import ru.tochitopor.atm.common.RequestTypes;*/
import ru.tochitopor.atm.client.service.ClientService;
import ru.tochitopor.atm.common.GetBalanceReqstDTO;
import ru.tochitopor.atm.common.GetBalanceRespnsDTO;

import java.util.Objects;

@RequestMapping("/ATM")
@AllArgsConstructor
@RestController
@Log
public class ClientController {
    private RestTemplate restTemplate;
    private ClientService clientService;
    private final String LOCAL_HOST = "http://127.0.0.1:8082";

    @GetMapping()
    public String getATMInfo() {
        return "Russian Moscow ATM Test 8081";
    }

    @GetMapping("/clients/{clientId}/scores/{scoreId}/{PIN}")
    public int getClientBalance(
            @PathVariable("clientId") long clientId,
            @PathVariable("scoreId") long scoreId,
            @PathVariable("PIN") int PIN) {

        log.info("clientId " + clientId + " scoreId " + scoreId + " PIN " + PIN);

        HttpEntity<GetBalanceReqstDTO> request =
                new HttpEntity<>(new GetBalanceReqstDTO(clientId,  scoreId, PIN));

        log.info("request.toString()" + request);

        GetBalanceRespnsDTO response;

        try {
            response = restTemplate.postForObject(
                    LOCAL_HOST + "/host/clients/getBalance", request, GetBalanceRespnsDTO.class);
        }
        catch (RestClientException e){
            log.warning(e.getMessage());
            throw new RestClientException(Objects.requireNonNull(e.getMessage()));
        }

        log.info("responseEntityStr.getBody()" + Objects.requireNonNull(response).getBalance());

        return clientService.getClientBalance(response);
    }
}
