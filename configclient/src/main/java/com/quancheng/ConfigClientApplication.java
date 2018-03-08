package com.quancheng;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RefreshScope
public class ConfigClientApplication {

    @Value("${content}")
    private String content;

    public static Gson gson = new Gson();

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @RequestMapping(value = "/getenv")
    public String print(){
        //String address = env.getProperty("alipay.url");
        System.err.println("===>" + content);
        return content;
    }
}
