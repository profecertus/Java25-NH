package pe.nh.demo07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.nh.demo07.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByEmailIgnoreCase(String email);
}
