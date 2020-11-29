package com.njesoft.eurekaclient;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrix
@EnableHystrixDashboard
public class EurekaClientApplication2 {

    private MyFeignClient myFeignClient;

    public EurekaClientApplication2(MyFeignClient myFeignClient) {
        this.myFeignClient = myFeignClient;
    }

    @RequestMapping("/")
    public String home() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "Hello world 2");
        jsonObject.put("message-3 ", new JSONObject(myFeignClient.client3Response()));

        return jsonObject.toString();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication2.class, args);
    }

}
