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

import meuclosetshop.backend.entidade.Marca;
import meuclosetshop.backend.servico.MarcaServico;

@RequestMapping("/marca")
@RestController
@CrossOrigin
public class MarcaControle {
    
    @Autowired
    private MarcaServico marcaServico;

    @GetMapping("/")
    public List<Marca> listarTodos(){
        return marcaServico.listarTodos();
    }

    @PostMapping("/")
    public Marca inserir(@RequestBody Marca marca){
        return marcaServico.inserir(marca);
    }

    @PutMapping("/")
    public Marca atualizar(@RequestBody Marca marca){
        return marcaServico.atualizar(marca);
    }

    @DeleteMapping("/")
    public void excluir(@PathVariable("id") Long id){
        marcaServico.excluir(id);
    }
}
