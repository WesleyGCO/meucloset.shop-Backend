package meuclosetshop.backend.servico;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuclosetshop.backend.entidade.Permissao;
import meuclosetshop.backend.repositorio.PermissaoRepositorio;

@Service
public class PermissaoServico {
    
    @Autowired
    private PermissaoRepositorio permissaoRepositorio;

    public List<Permissao> listarTodasPermissoes(){
        return permissaoRepositorio.findAll();
    }

    public Permissao inserirPermissao(Permissao permissao){
        permissao.setDataCriacao(new Date());
        Permissao permissaoNova = permissaoRepositorio.saveAndFlush(permissao);
        return permissaoNova;
    }

    public Permissao atualizarPermissao(Permissao permissao){
        permissao.setDataAtualizacao(new Date());
        Permissao permissaoAtualizada = permissaoRepositorio.saveAndFlush(permissao);
        return permissaoAtualizada;
    }

    public void excluirPermissao(Long id){
        Permissao permissao = permissaoRepositorio.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Permissão não encontrada"));
        permissaoRepositorio.delete(permissao);
    }
}
