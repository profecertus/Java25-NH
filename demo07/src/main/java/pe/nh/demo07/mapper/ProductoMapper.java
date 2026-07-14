package pe.nh.demo07.mapper;

import pe.nh.demo07.dto.*;
import pe.nh.demo07.model.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper{
    Producto aEntidad(CrearProductoDTO dto);

    ProductoResponse aResponse(Producto p);
}