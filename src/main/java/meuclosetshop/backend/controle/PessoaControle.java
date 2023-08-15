package meuclosetshop.backend.controle;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import meuclosetshop.backend.entidade.Pessoa;
import meuclosetshop.backend.servico.PessoaServico;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin
public class PessoaControle {

    @Autowired
    private PessoaServico pessoaServico;

    // localhost:8080/pessoa/ - com verbo get
    @GetMapping("/")
    public List<Pessoa> listarTodasPessoas() {
        return pessoaServico.listarTodasPessoas();
    }

    // localhost:8080/pessoa/ - com verbo post
    @PostMapping("/")
    public Pessoa inserir(@RequestBody Pessoa pessoa) {
        return pessoaServico.inserirPessoa(pessoa);
    }

    @PutMapping("/")
    public Pessoa atualizar(@RequestBody Pessoa pessoa) {
        return pessoaServico.atualizarPessoa(pessoa);
    }

    // localhost:8080/pessoa/1 - com verbo delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirPessoa(@PathVariable Long id) {
        try {
            pessoaServico.excluirPessoa(id);
            return ResponseEntity.ok("Pessoa excluída com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/cidade")
    public List<Pessoa> findByCidade_id(@PathParam("idCidade") Long idCidade) {
        return pessoaServico.findByCidade_id(idCidade);
    }
}
