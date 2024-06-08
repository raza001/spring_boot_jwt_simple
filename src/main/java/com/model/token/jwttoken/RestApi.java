package com.model.token.jwttoken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class RestApi {

    @Autowired
    private jwtutils jwtutils;

    @GetMapping("/emp")
    public String all() {
        System.out.println(jwtutils.doGenerateToken());
        System.out.println("--------------------------------------------------------");
        System.out.println(jwtutils.getAllClaimsFromToken(jwtutils.doGenerateToken()).getSubject());
        return "helllo india";
    }
}
