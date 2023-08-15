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

import meuclosetshop.backend.entidade.PermissaoPessoa;
import meuclosetshop.backend.servico.PermissaoPessoaServico;

@RestController
@RequestMapping("/permissaoPessoa")
@CrossOrigin
public class PermissaoPessoaControle {
    @Autowired
    private PermissaoPessoaServico permissaoPessoaServico;

    // localhost:8080/permissaoPessoa/ - com verbo get
    @GetMapping("/")
    public List<PermissaoPessoa> listarPermissaoPessoas() {
        return permissaoPessoaServico.listarPermissaoPessoas();
    }

    // localhost:8080/permissaoPessoa/ - com verbo post
    @PostMapping("/")
    public PermissaoPessoa inserirPermissaoPessoa(@RequestBody PermissaoPessoa permissaoPessoa) {
        return permissaoPessoaServico.inserirPermissaoPessoa(permissaoPessoa);
    }

    @PutMapping("/")
    public PermissaoPessoa atualizarPermissaoPessoa(@RequestBody PermissaoPessoa permissaoPessoa) {
        return permissaoPessoaServico.atualizarPermissaoPessoa(permissaoPessoa);
    }

    // localhost:8080/permissaoPessoa/1 - com verbo delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirPermissaoPessoa(@PathVariable Long id) {
        try {
            permissaoPessoaServico.excluirPermissaoPessoa(id);
            return ResponseEntity.ok("Permissao de pessoa excluído com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
