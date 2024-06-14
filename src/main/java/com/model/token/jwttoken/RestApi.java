package com.model.token.jwttoken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class RestApi {

    @Autowired
    private jwtutils jwtutils;
    @Autowired
    private PasswordEncoder passwordEncoder;

   @Value("${environment.name}")
   private String name;

    @GetMapping("/emp")
    public String all() {
//         System.out.println(passwordEncoder.encode("HEllo india"));
//        System.out.println(passwordEncoder.matches("HEllo", passwordEncoder.encode("HEllo india")));
//        System.out.println(jwtutils.doGenerateToken());
        System.out.println("--------------------------------------------------------");
//        System.out.println(jwtutils.getAllClaimsFromToken(jwtutils.doGenerateToken()).getSubject());
        System.out.println("---"+name);

        return "helllo india";
    }
}
