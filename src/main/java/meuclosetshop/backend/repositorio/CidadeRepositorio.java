package meuclosetshop.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import meuclosetshop.backend.entidade.Cidade;

public interface CidadeRepositorio extends JpaRepository<Cidade, Long> {
}
