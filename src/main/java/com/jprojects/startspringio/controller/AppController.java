package com.jprojects.startspringio.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Value("${app.message}")
    private String appMessage;

    @Value("${ENV_URL:NULL}")
    private String dbEnvVar;

    @GetMapping("/app")
    public String getAppMessage() {
        return appMessage;
    }

    @GetMapping("/env")
    public String getDbEnvVar() {
        return "Ambiente ativo: " + dbEnvVar;
    }
}
