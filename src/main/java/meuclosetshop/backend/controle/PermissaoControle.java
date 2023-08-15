package meuclosetshop.backend.controle;

import java.util.List;

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

import meuclosetshop.backend.entidade.Permissao;
import meuclosetshop.backend.servico.PermissaoServico;

@RestController
@RequestMapping("/permissao")
@CrossOrigin
public class PermissaoControle {
    @Autowired
    private PermissaoServico permissaoServico;

    // localhost:8080/permissao/ - com verbo get
    @GetMapping
    public List<Permissao> listarTodasPermissoes(){
        return permissaoServico.listarTodasPermissoes();
    }

    // localhost:8080/permissao/ - com verbo post
    @PostMapping
    public Permissao inserir(@RequestBody Permissao permissao){
    return permissaoServico.inserirPermissao(permissao);
    }

    @PutMapping("/")
    public Permissao atualizar(@RequestBody Permissao permissao){
        return permissaoServico.atualizarPermissao(permissao);
    }

    // localhost:8080/permissao/1 - com verbo delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirPermissao(@PathVariable Long id){
        try {
            permissaoServico.excluirPermissao(id);
            return ResponseEntity.ok("Permissão excluída com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
