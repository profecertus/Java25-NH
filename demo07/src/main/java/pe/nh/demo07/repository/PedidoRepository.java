package pe.nh.demo07.repository;

import java.util.Optional;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import pe.nh.demo07.model.EstadoPedido;
import pe.nh.demo07.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Page<Pedido> findByEstado(EstadoPedido estado, Pageable pageable);

    @EntityGraph(attributePaths = {"cliente", "detalles", "detalles.producto", "pago"})
    Optional<Pedido> findById(Long id);
}
