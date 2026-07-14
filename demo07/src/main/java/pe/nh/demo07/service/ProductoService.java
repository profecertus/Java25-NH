package pe.nh.demo07.service;

import org.springframework.stereotype.Service;
import java.util.List;

import pe.nh.demo07.dto.CrearProductoDTO;
import pe.nh.demo07.dto.ProductoResponse;
import pe.nh.demo07.mapper.ProductoMapper;
import pe.nh.demo07.model.Producto;
import lombok.AllArgsConstructor;
import pe.nh.demo07.repository.ProductoRepository;

@AllArgsConstructor
@Service
public class ProductoService {
    private ProductoRepository productoRepository;
    private ProductoMapper productoMapper;

    public List<Producto> listar(){
        return this.productoRepository.findAll();
    }

    public ProductoResponse crear(CrearProductoDTO dto){
        Producto entidad = productoMapper.aEntidad(dto);
        Producto guardado = productoRepository.save(entidad);
        return productoMapper.aResponse(guardado);
    }
}