package pe.nh.demo07.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Datos de respuesta de un cliente")
public record ClienteResponse(
    @Schema(description = "Identificador del cliente", example = "1")
    Long id,

    @Schema(description = "Nombre del cliente", example = "Juan Pérez")
    String nombre,

    @Schema(description = "Email del cliente", example = "juan.perez@example.com")
    String email
) {

}
