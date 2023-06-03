package meuclosetshop.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import meuclosetshop.backend.entidade.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

}
