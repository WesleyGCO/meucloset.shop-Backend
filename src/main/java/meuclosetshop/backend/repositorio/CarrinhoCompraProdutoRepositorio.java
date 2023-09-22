package meuclosetshop.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import meuclosetshop.backend.entidade.CarrinhoCompraProduto;

public interface CarrinhoCompraProdutoRepositorio extends JpaRepository<CarrinhoCompraProduto, Long>{
    
}
