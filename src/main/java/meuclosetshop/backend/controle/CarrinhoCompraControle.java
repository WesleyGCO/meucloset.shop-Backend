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

import meuclosetshop.backend.entidade.CarrinhoCompra;
import meuclosetshop.backend.servico.CarrinhoCompraServico;

@RequestMapping("/carrinhoCompra")
@RestController
@CrossOrigin
public class CarrinhoCompraControle {
    
    @Autowired
    private CarrinhoCompraServico carrinhoCompraServico;

    @GetMapping
    public List<CarrinhoCompra> listarTodos(){
        return carrinhoCompraServico.listarTodos();
    }

    @PostMapping
    public CarrinhoCompra inserirCarrinhoCompra(@RequestBody CarrinhoCompra carrinhoCompra){
        return carrinhoCompraServico.inserirCarrinhoCompra(carrinhoCompra);
    }

    @PutMapping
    public CarrinhoCompra atualizarCarrinhoCompra(@RequestBody CarrinhoCompra carrinhoCompra){
        return carrinhoCompraServico.atualizarCarrinhoCompra(carrinhoCompra);
    }

    @DeleteMapping
    public void excluirCarrinhoCompra(@PathVariable("id") Long id){
        carrinhoCompraServico.excluirCarrinhoCompra(id);
    }
}
