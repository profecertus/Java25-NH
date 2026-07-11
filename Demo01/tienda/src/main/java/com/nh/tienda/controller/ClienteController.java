package com.nh.tienda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import java.util.*;
import com.nh.tienda.entity.*;
import com.nh.tienda.service.ClienteService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {    
    private ClienteService clienteService;    
    
    @GetMapping("/getAll")
    public ResponseEntity<List<Cliente>> getAllClientes(){
        return ResponseEntity.ok(this.clienteService.getAllClientes());
    }
    
}
