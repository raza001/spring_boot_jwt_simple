package com.model.token.jwttoken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping("temp")
    public String temp(Model model) {
        model.addAttribute("message", "attr");
        return "hell";
    }
    @GetMapping("/test")
    public String test() {
        return "hello.html";
    }
}