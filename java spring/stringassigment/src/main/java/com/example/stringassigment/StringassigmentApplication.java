package com.example.stringassigment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class StringassigmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StringassigmentApplication.class, args);
    }
    @RequestMapping("/")
    public String index() {
        return "Hello Client ! How are you doing ?";
    }

    @RequestMapping("/random")
    public String rand() {
        return "Spring boot is great! So easy to just respond with strings";
    }}