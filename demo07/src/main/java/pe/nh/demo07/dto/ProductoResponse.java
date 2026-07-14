package pe.nh.demo07.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="Representacion de un producto tal como la devuelve la API")
public record ProductoResponse(
    @Schema(example = "7")
    Integer id,

    @Schema(example = "Laptop")
    String nombre, 

    @Schema(example = "3000.0")
    double precio,

    @Schema(example = "tech")
    String categoria
) {
    
}
