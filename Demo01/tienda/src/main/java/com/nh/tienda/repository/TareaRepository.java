package com.nh.tienda.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import com.nh.tienda.entity.*;
import org.springframework.stereotype.Repository;


/**
 * TareaRepository
 */
interface TareaRepositoryInterface {
    Tarea guardar(String titulo);
    List<Tarea> listar();    
} 

@Repository
public class TareaRepository implements TareaRepositoryInterface{
    private final Map<Integer, Tarea> db = new LinkedHashMap<>(); 
    private final AtomicInteger seq = new AtomicInteger(); 

    @Override   
     public Tarea guardar(String titulo) { 
        int id = seq.incrementAndGet(); 
        Tarea t = new Tarea(id, titulo); 
        db.put(id, t); 
        return t; 
    } 

    @Override
    public List<Tarea> listar() { return new ArrayList<>(db.values()); } 
}
