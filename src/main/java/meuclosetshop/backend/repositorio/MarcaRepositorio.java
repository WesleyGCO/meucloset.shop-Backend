package meuclosetshop.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import meuclosetshop.backend.entidade.Marca;

public interface MarcaRepositorio extends JpaRepository<Marca, Long> {

}
