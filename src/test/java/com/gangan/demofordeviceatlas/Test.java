package com.gangan.demofordeviceatlas;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Test {

    public static void main(String[] args) {
        String url = "Dalvik%2F2.1.0%20%28Linux%3B%20U%3B%20Android%2010%3B%20ACTAB1021%20Build%2FQP1A.190711.020%29";
        System.out.println(url);

        String decode = URLDecoder.decode(url, StandardCharsets.UTF_8);
        System.out.println(decode);

        String encode = URLEncoder.encode(decode, StandardCharsets.UTF_8).replace("+", "%20");
        System.out.println(encode);
    }

}
