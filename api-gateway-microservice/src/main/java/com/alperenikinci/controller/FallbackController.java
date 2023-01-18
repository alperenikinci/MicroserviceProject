package com.alperenikinci.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class FallbackController {

    @GetMapping("/fallbackauth")
    public ResponseEntity<String> fallBackAuth(){
        return ResponseEntity.ok("Servis şu an çalışmıyor. Başka zaman.. :)");
    }

    @GetMapping("/fallbackproduct")
    public ResponseEntity<String> fallBackProduct(){
        return ResponseEntity.ok("Servis şu an çalışmıyor. Başka zaman.. :)");
    }
    @GetMapping("/fallbacksales")
    public ResponseEntity<String> fallBackSales(){
        return ResponseEntity.ok("Servis şu an çalışmıyor. Başka zaman.. :)");
    }

    @GetMapping("/fallbackuser")
    public ResponseEntity<String> fallBackUser(){
        return ResponseEntity.ok("Servis şu an çalışmıyor. Başka zaman.. :)");
    }

}
