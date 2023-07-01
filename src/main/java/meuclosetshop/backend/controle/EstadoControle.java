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

import meuclosetshop.backend.entidade.Estado;
import meuclosetshop.backend.servico.EstadoServico;

@RequestMapping("/estado")
@RestController
@CrossOrigin
public class EstadoControle {
    @Autowired
    private EstadoServico estadoServico;

    @GetMapping
    public List<Estado> listarTodosEstados(){
        return estadoServico.listarTodosEstados();
    }

    @PostMapping
    public Estado inserirEstado(@RequestBody Estado estado){
        return estadoServico.inserirEstado(estado);
    }

    @PutMapping
    public Estado atualizarEstado(@RequestBody Estado estado){
        return estadoServico.atualizarEstado(estado);
    }

    @DeleteMapping("/{id}")
    public void excluirEstado(@PathVariable("id") Long id){
        estadoServico.excluirEstado(id);
    }
}
