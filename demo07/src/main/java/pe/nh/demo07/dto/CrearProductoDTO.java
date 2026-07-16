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
    @NotBlank(message="{validacion.producto.nombre}")
    @Size(min=2, max=100, message="{validacion.producto.nombre.size}")
    String nombre,

    @Schema(example="3000.0")
    @Positive(message = "{validacion.producto.precio}")
    @DecimalMax(value = "1000000.0", message = "{validacion.producto.precio.max}")
    @Digits(integer = 7, fraction = 2, message = "{validacion.producto.precio.digits}")
    double precio,

    @Schema(example="tech")
    @Size(max = 280, message = "{validacion.producto.categoria.obligatoria}")
    @CategoriaValida
    String categoria
){}
