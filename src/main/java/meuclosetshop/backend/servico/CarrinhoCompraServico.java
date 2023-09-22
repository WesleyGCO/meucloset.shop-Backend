package meuclosetshop.backend.servico;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuclosetshop.backend.entidade.CarrinhoCompra;
import meuclosetshop.backend.repositorio.CarrinhoCompraRepositorio;

@Service
public class CarrinhoCompraServico {
    
    @Autowired
    private CarrinhoCompraRepositorio carrinhoCompraRepositorio;

    public List<CarrinhoCompra> listarTodos(){
        return carrinhoCompraRepositorio.findAll();
    }

    public CarrinhoCompra inserirCarrinhoCompra(CarrinhoCompra carrinhoCompra){
        carrinhoCompra.setDataCriacao(new Date());
        CarrinhoCompra carrinhoCompraNovo = carrinhoCompraRepositorio.saveAndFlush(carrinhoCompra);
        return carrinhoCompraNovo;
    }

    public CarrinhoCompra atualizarCarrinhoCompra(CarrinhoCompra carrinhoCompra){
        carrinhoCompra.setDataAtualizacao(new Date());
        CarrinhoCompra carrinhoCompraAtualizado = carrinhoCompraRepositorio.saveAndFlush(carrinhoCompra);
        return carrinhoCompraAtualizado;
    }

    public void excluirCarrinhoCompra(Long id){
        CarrinhoCompra carrinhoCompraExcluido = carrinhoCompraRepositorio.findById(id).get();
        carrinhoCompraRepositorio.delete(carrinhoCompraExcluido);
    }
}
