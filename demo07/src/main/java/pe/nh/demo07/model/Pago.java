package pe.nh.demo07.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pagos")
@Data
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private MetodoPago metodo;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal monto;

    @Column(nullable = false)
    private LocalDateTime fechaPago = LocalDateTime.now();

    @OneToOne(mappedBy = "pago")
    private Pedido pedido;

    public Pago(MetodoPago metodoPago, BigDecimal monto) {
        this.metodo = metodoPago;
        this.monto = monto;        
    }
}
