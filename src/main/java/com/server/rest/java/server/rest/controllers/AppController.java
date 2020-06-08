package com.server.rest.java.server.rest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/example")
public class AppController {

  @GetMapping("/hello-world")
  public ResponseEntity<String> get() {
    return ResponseEntity.ok("Hola Mundo!");
  }

}

