package meuclosetshop.backend.servico;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuclosetshop.backend.entidade.CarrinhoCompraProduto;
import meuclosetshop.backend.repositorio.CarrinhoCompraProdutoRepositorio;

@Service
public class CarrinhoCompraProdutoServico {
    
    @Autowired
    private CarrinhoCompraProdutoRepositorio carrinhoCompraProdutoRepositorio;

    public List<CarrinhoCompraProduto> listarTodos(){
        return carrinhoCompraProdutoRepositorio.findAll();
    }

    public CarrinhoCompraProduto inserirCarrinhoCompraProduto(CarrinhoCompraProduto carrinhoCompraProduto){
        carrinhoCompraProduto.setDataCriacao(new Date());
        CarrinhoCompraProduto carrinhoCompraProdutoNovo = carrinhoCompraProdutoRepositorio.saveAndFlush(carrinhoCompraProduto);
        return carrinhoCompraProdutoNovo;
    }

    public CarrinhoCompraProduto atualizarCarrinhoCompraProduto(CarrinhoCompraProduto carrinhoCompraProduto){
        carrinhoCompraProduto.setDataAtualizacao(new Date());
        CarrinhoCompraProduto carrinhoCompraProdutoAtualizado = carrinhoCompraProdutoRepositorio.saveAndFlush(carrinhoCompraProduto);
        return carrinhoCompraProdutoAtualizado;
    }

    public void excluirCarrinhoCompraProduto(Long id){
        CarrinhoCompraProduto carrinhoCompraProdutoExcluido = carrinhoCompraProdutoRepositorio.findById(id).get();
        carrinhoCompraProdutoRepositorio.delete(carrinhoCompraProdutoExcluido);
    }
}
