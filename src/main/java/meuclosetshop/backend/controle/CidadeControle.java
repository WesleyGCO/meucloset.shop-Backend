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

import meuclosetshop.backend.entidade.Cidade;
import meuclosetshop.backend.servico.CidadeServico;

@RequestMapping("/cidade")
@RestController
@CrossOrigin
public class CidadeControle {
    
    @Autowired
    private CidadeServico cidadeServico;

    @GetMapping
    public List<Cidade> listarTodasCidades(){
        return cidadeServico.listarTodasCidades();
    }

    @PostMapping
    public Cidade inserirCidade(@RequestBody Cidade cidade){
        return cidadeServico.inserirCidade(cidade);
    }

    @PutMapping
    public Cidade atualizarCidade(@RequestBody Cidade cidade){
        return cidadeServico.atualizarCidade(cidade);
    }

    @DeleteMapping("/{id}")
    public void excluirCidade(@PathVariable("id") Long id){
        cidadeServico.excluirCidade(id);
    }
}
