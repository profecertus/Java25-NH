package pe.nh.demo07.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Datos para crear un cliente")
public record CrearClienteDTO(
    @Schema(description = "Nombre del cliente", example = "Juan Pérez")
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min=2, max=100, message = "El nombre no puede tener más de 100 caracteres")
    String nombre,

    @Schema(description = "Email del cliente", example = "juan.perez@example.com")
    @NotBlank(message = "El email es obligatorio")
    @Size(min=2, max=100, message = "El email no puede tener más de 100 caracteres")
    String email
) {        
}
