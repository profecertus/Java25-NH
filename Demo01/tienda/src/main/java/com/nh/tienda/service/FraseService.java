package com.nh.tienda.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

@Service
public class FraseService {
    private List<String> frases = new ArrayList<>(List.of(
            "El codigo limpio se lee como prosa.",
            "Programa contra interfaces, no implementaciones.",
            "Hazlo simple, luego hazlo rapido."));

    public List<String> todas() {
        return frases;
    }

    public String aleatoria() {
        return frases.get(ThreadLocalRandom.current().nextInt(frases.size()));
    }

    public Integer contarFrases() {
        return frases.size();
    }

    public void agregarFrase(String frase) {
        frases.add(frase);
    }
}