package meuclosetshop.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import meuclosetshop.backend.entidade.Estado;

public interface EstadoRepositorio extends JpaRepository<Estado, Long>{
    
}
