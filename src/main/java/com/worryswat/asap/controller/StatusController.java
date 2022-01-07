package com.worryswat.asap.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/status")
public class StatusController {

    @Value("${spring.rest.uri}")
    private String restUri;
    private final RestTemplate restTemplate;

    @GetMapping("/server")
    public String serverStatus(){
        String uri = restUri + "status/server";
        String response = restTemplate.getForObject(uri, String.class);

        return "ok / "+response;
    }

}
