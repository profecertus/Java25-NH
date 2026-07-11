package com.nh.tienda.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.nh.tienda.service.FraseService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class FraseController {

    private FraseService fraseService;

    @GetMapping("/frase")
    public String aleatoria() {
        return this.fraseService.aleatoria();
    }

    @GetMapping("/frases")
    public List<String> todas() {
        return this.fraseService.todas();
    }

    @GetMapping("/frases/contar")
    public Integer contarFrases() {
        return this.fraseService.contarFrases();
    }

    @PostMapping("/frases")
    public void agregar(@RequestParam(defaultValue = "Vacio") String frase) {
        this.fraseService.agregarFrase(frase);
    }
}