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

import meuclosetshop.backend.entidade.Categoria;
import meuclosetshop.backend.servico.CategoriaServico;

@RequestMapping("/categoria")
@RestController
@CrossOrigin
public class CategoriaControle {
    
    @Autowired
    private CategoriaServico categoriaServico;

    @GetMapping("/")
    public List<Categoria> listarTodos(){
        return categoriaServico.listarTodos();
    }

    @PostMapping("/")
    public Categoria inserir(@RequestBody Categoria categoria){
        return categoriaServico.inserir(categoria);
    }

    @PutMapping("/")
    public Categoria atualizar(@RequestBody Categoria categoria){
        return categoriaServico.atualizar(categoria);
    }

    @DeleteMapping("/")
    public void excluir(@PathVariable("id") Long id){
        categoriaServico.excluir(id);
    }
}
