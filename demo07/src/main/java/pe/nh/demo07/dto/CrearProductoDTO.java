package pe.nh.demo07.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Schema(description="Datos que el cliente envia para crear/actualizar un producto")
public record CrearProductoDTO(
    @Schema(example="Laptop")
    @NotBlank(message="el nombre es obligatorio")
    String nombre,

    @Schema(example="3000.0")
    @Positive(message = "el precio debe ser > 0")
    double precio,

    @Schema(example="tech")
    @Size(max = 280, message = "la categoria no puede superar los 280 caracteres")
    String categoria
){}
