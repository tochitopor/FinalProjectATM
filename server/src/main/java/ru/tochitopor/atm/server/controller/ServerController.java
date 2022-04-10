package ru.tochitopor.atm.server.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import ru.tochitopor.atm.common.GetBalanceReqstDTO;
import ru.tochitopor.atm.common.GetBalanceRespnsDTO;
import ru.tochitopor.atm.server.entity.Client;
import ru.tochitopor.atm.server.service.ServerService;


@RestController
@AllArgsConstructor
@RequestMapping("/host")
@Log
public class ServerController {
    private ServerService serverService;

    @GetMapping()
    public String getHostsInfo() {

        return "Russian Moscow Host Test 8082";
    }

    @PostMapping(path = "/clients/getBalance", consumes = "application/json" )
    public GetBalanceRespnsDTO getBalance(@RequestBody GetBalanceReqstDTO request) {
        log.info(request.toString());

        Client client = serverService.getClient(request.getClientId());
        serverService.checkPIN(client,request.getPin());

        GetBalanceRespnsDTO response = new GetBalanceRespnsDTO(serverService.getScore(client, request.getScoreId()).getBalance());

        log.info(response.toString());

        return response;


    }

}
