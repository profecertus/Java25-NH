package pe.nh.demo07.service;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

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

    public Page<ProductoResponse> listar(String categoria, Pageable pageable){
        Page<Producto> pagina = (categoria == null || categoria.isBlank())
                                ? productoRepository.findAll(pageable)
                                : productoRepository.findByCategoria(categoria, pageable);
        return pagina.map(productoMapper::aResponse);
    }

    public ProductoResponse crear(CrearProductoDTO dto){
        Producto entidad = productoMapper.aEntidad(dto);
        Producto guardado = productoRepository.save(entidad);
        return productoMapper.aResponse(guardado);
    }
}