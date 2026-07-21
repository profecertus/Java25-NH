package pe.nh.demo07.model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@Embeddable
@Data
public class DetallePedidoId implements Serializable {
    @Column(name = "pedido_id")
    private Long pedidoId;
    
    @Column(name = "producto_id")
    private Integer productoId;
}
