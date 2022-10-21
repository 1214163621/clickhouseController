package com.example.demo.common;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;

public class Httprequest {
public static JSONObject request(String url, JSONObject body, String signature,String key){
    JSONObject jsonObject =JSONObject.parseObject(HttpRequest.post("https://10.10.228.200:443/artemis/api"+ url)
            .header("X-Ca-Key", key)//头信息，多个头信息多次调用此方法即可
            .header("X-Ca-Signature-Headers", "x-ca-key")//头信息，多个头信息多次调用此方法即可
            .header("X-Ca-Signature", signature)//头信息，多个头信息多次调用此方法即可
            .header(Header.ACCEPT, "*/*")//头信息，多个头信息多次调用此方法即可
            .header(Header.CONTENT_TYPE, "application/json")//头信息，多个头信息多次调用此方法即可
            .body(body.toString())//表单内容
            .timeout(20000)
            .execute().body());
    return jsonObject;
}
}
