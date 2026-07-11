package com.nh.tienda.service;

import org.springframework.stereotype.Service;
import com.nh.tienda.repository.*;
import com.nh.tienda.entity.*;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Service
public
class TareaService {
    private final TareaRepository repo;    

    public Tarea crear(String titulo) {
        if (titulo == null || titulo.isBlank())
            throw new IllegalArgumentException("titulo vacio");
        return repo.guardar(titulo.trim());
    }

    public List<Tarea> listar() {
        return repo.listar();
    }
}
