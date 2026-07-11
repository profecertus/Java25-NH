package com.nh.tienda.controller;

import org.springframework.web.bind.annotation.*;
import com.nh.tienda.service.*;
import lombok.AllArgsConstructor;
import com.nh.tienda.entity.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/tareas")
public class TareaController {
    private TareaService service;

    
    @GetMapping("/listar")
    public List<Tarea> listar() {
        return service.listar();
    }

    @PostMapping("/crear")
    public Tarea crear(@RequestParam String titulo) { return service.crear(titulo);}
}