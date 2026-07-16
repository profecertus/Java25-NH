package pe.nh.demo07.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import pe.nh.demo07.validation.CategoriaValida;

@Schema(description="Datos que el cliente envia para crear/actualizar un producto")
public record CrearProductoDTO(
    @Schema(example="Laptop")
    @NotBlank(message="El nombre es obligatorio")
    @Size(min=2, max=100, message="El nombre debe ser mayor 2 menor 100")
    String nombre,

    @Schema(example="3000.0")
    @Positive(message = "El precio debe ser > 0")
    @DecimalMax(value = "1000000.0", message = "El maximo valor es 1000000")
    @Digits(integer = 7, fraction = 2, message = "El precio es de 7 enteros y 2 digitos")
    double precio,

    @Schema(example="tech")
    @Size(max = 280, message = "La categoria no puede superar los 280 caracteres")
    @CategoriaValida
    String categoria
){}
