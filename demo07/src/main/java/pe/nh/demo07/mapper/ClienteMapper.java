package pe.nh.demo07.mapper;

import org.mapstruct.Mapper;

import pe.nh.demo07.dto.ClienteResponse;
import pe.nh.demo07.dto.CrearClienteDTO;
import pe.nh.demo07.model.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    Cliente aEntidad(CrearClienteDTO dto);
    ClienteResponse aResponse(Cliente c);
}
