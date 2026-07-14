package pe.nh.demo07.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import pe.nh.demo07.dto.CrearProductoDTO;
import pe.nh.demo07.dto.ProductoResponse;
import pe.nh.demo07.model.Producto;
import pe.nh.demo07.service.ProductoService;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/productos")
@Tag(name="Productos", description="CRUD REST de productos (Sesion 7)")
public class ProductoController {
    private ProductoService productoService;

    @GetMapping("/listar")
    @Operation(summary = "Listas los productos",
        description = "Devuelve los productos totals, no acepta filtros"
    )
    public ResponseEntity<List<Producto>> listar() {
        return ResponseEntity.ok(this.productoService.listar());
    }

    @PostMapping
    @Operation(summary = "Crear un producto",
        description = "Recibe el JSON del cuerpo, lo valida y devuelve 201 en la cabecera Location"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Producto creado"),
        @ApiResponse(responseCode = "400", description = "Datos Invalidos"),
    })
    public ResponseEntity<ProductoResponse> crear(@Valid @RequestBody CrearProductoDTO dto) {
        ProductoResponse creado = productoService.crear(dto);
        URI location = URI.create("/api/v1/productos/" + creado.id());
        return ResponseEntity.created(location).body(creado);
    }
    
    
}
