package com.njesoft.eurekaclient;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;

@Component()
public class MyFeignClientFallbackImpl implements MyFeignClient{
    @Override
    public String client2Response() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("message", "Hello world 1");
            jsonObject.put("message-2 ", "Hello world 8002 is down");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject.toString();
    }
}
