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

import meuclosetshop.backend.entidade.Produto;
import meuclosetshop.backend.servico.ProdutoServico;

@RequestMapping("/produto")
@RestController
@CrossOrigin
public class ProdutoControle {
    
    @Autowired
    private ProdutoServico produtoServico;

    @GetMapping("/")
    public List<Produto> listarTodos(){
        return produtoServico.listarTodos();
    }

    @PostMapping("/")
    public Produto inserir(@RequestBody Produto produto){
        return produtoServico.inserir(produto);
    }

    @PutMapping("/")
    public Produto atualizar(@RequestBody Produto produto){
        return produtoServico.atualizar(produto);
    }

    @DeleteMapping("/")
    public void excluir(@PathVariable("id") Long id){
        produtoServico.excluir(id);
    }
}
