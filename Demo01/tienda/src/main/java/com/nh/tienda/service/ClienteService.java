package com.nh.tienda.service;

import java.util.*;
import com.nh.tienda.entity.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    public List<Cliente> getAllClientes(){
        List<Cliente> clientes = List.of(
            Cliente.builder()
            .nombre("Edwin")
            .direeccion("Callao")
            .idCliente(1L)
            .build(),
            Cliente.builder()
            .nombre("Jose")
            .direeccion("Surco")
            .idCliente(2L)
            .build()

        );
        return clientes;
    }

}
