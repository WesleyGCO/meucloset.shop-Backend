package meuclosetshop.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import meuclosetshop.backend.entidade.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>{
    
}
