package meuclosetshop.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import meuclosetshop.backend.entidade.CarrinhoCompra;

public interface CarrinhoCompraRepositorio extends JpaRepository<CarrinhoCompra, Long>{
    
}
