package com.nh.tienda.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class SaludoController {
    @GetMapping("/saludo")
    public String saludo(@RequestParam(defaultValue = "mundo") String nombre) {
        return "Hola " + nombre + " desde SpringBoot!!!";
    }

    @GetMapping("/hora")
    public String hora() {        
        return (new Date()).toString();
    }
    
    @GetMapping("/suma")
    public int suma(@RequestParam(defaultValue = "0") int a, 
        @RequestParam(defaultValue = "0") int b) {
        return (a+b);
    }
       
}
