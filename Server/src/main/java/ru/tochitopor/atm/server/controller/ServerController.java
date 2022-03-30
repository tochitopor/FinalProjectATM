package ru.tochitopor.atm.server.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import ru.tochitopor.atm.common.ResponseDTO;
import ru.tochitopor.atm.common.Request;
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

    @PostMapping("/clients/{clientId}/getBalance")
    public ResponseDTO getBalance(@PathVariable("clientId") Long clientId,
                                  @RequestBody Request request) {

        System.out.println("tut1");
        log.info(request.toString());

        ResponseDTO response = new ResponseDTO(serverService.getClient(clientId).getScores().get(0).getBalance());

        System.out.println("tut2");
        log.info(response.toString());

        return response;
    }

}
