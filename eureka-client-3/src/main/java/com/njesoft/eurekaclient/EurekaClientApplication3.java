package com.njesoft.eurekaclient;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication3 {

    @RequestMapping("/eureka-client-3")
    public String home() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "Hello world 3");

        return jsonObject.toString();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication3.class, args);
    }

}
