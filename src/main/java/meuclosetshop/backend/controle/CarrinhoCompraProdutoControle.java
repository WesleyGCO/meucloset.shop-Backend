package meuclosetshop.backend.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import meuclosetshop.backend.entidade.CarrinhoCompraProduto;
import meuclosetshop.backend.servico.CarrinhoCompraProdutoServico;

@RequestMapping("/carrinhoCompraProduto")
@RestController
@CrossOrigin
public class CarrinhoCompraProdutoControle {
    
    @Autowired
    private CarrinhoCompraProdutoServico carrinhoCompraProdutoServico;

    @GetMapping
    public List<CarrinhoCompraProduto> listarTodos(){
        return carrinhoCompraProdutoServico.listarTodos();
    }

    @PostMapping
    public CarrinhoCompraProduto inserirCarrinhoCompraProduto(@RequestBody CarrinhoCompraProduto carrinhoCompraProduto){
        return carrinhoCompraProdutoServico.inserirCarrinhoCompraProduto(carrinhoCompraProduto);
    }

    @PutMapping
    public CarrinhoCompraProduto atualizarCarrinhoCompraProduto(@RequestBody CarrinhoCompraProduto carrinhoCompraProduto){
        return carrinhoCompraProdutoServico.atualizarCarrinhoCompraProduto(carrinhoCompraProduto);
    }

    @DeleteMapping
    public void excluirCarrinhoCompraProduto(@PathVariable("id") Long id){
        carrinhoCompraProdutoServico.excluirCarrinhoCompraProduto(id);
    }
}
