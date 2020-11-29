package com.njesoft.eurekaclient;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.codehaus.jettison.json.JSONObject;


@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrix
@EnableHystrixDashboard
public class EurekaClientApplication1 {


    private MyFeignClient myFeignClient;

    public EurekaClientApplication1(MyFeignClient myFeignClient) {
        this.myFeignClient = myFeignClient;
    }

    @RequestMapping("/")
    public String home() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "Hello world 1");
        jsonObject.put("message-2 ", new JSONObject(myFeignClient.client2Response()));

        return jsonObject.toString();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication1.class, args);
    }

}
