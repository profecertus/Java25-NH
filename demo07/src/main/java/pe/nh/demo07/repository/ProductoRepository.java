package pe.nh.demo07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.nh.demo07.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
    
}
