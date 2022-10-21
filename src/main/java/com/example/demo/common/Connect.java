package com.example.demo.common;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;

public class Connect {
    public static JSONObject request(String url){
        JSONObject jsonObject =JSONObject.parseObject(HttpRequest.get(url)
//                .header("X-Ca-Key", key)//头信息，多个头信息多次调用此方法即可
//                .header("X-Ca-Signature-Headers", "x-ca-key")//头信息，多个头信息多次调用此方法即可
//                .header("X-Ca-Signature", signature)//头信息，多个头信息多次调用此方法即可
//                .header(Header.ACCEPT, "*/*")//头信息，多个头信息多次调用此方法即可
//                .header(Header.CONTENT_TYPE, "application/json")//头信息，多个头信息多次调用此方法即可
//                .body(body.toString())//表单内容
                .timeout(20000)
                .execute().body());
        return jsonObject;
    }
}
