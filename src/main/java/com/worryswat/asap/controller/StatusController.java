package com.worryswat.asap.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/status")
public class StatusController {
    private final String restUri = "http://spring-rest/";
    private final RestTemplate restTemplate;

    @GetMapping("/server")
    public String serverStatus(){
        String uri = restUri + "status/server";
        String response = restTemplate.getForObject(uri, String.class);

        return "ok / "+response;
    }

}
