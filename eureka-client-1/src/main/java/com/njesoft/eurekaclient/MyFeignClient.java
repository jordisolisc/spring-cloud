package com.njesoft.eurekaclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "${feign.name}", url = "${feign.url}", fallback = MyFeignClientFallbackImpl.class)
public interface MyFeignClient {

    @GetMapping
    String client2Response();
}
