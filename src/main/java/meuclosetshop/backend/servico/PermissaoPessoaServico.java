package meuclosetshop.backend.servico;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuclosetshop.backend.entidade.Permissao;
import meuclosetshop.backend.entidade.PermissaoPessoa;
import meuclosetshop.backend.entidade.Pessoa;
import meuclosetshop.backend.repositorio.PermissaoPessoaRepositorio;
import meuclosetshop.backend.repositorio.PermissaoRepositorio;

@Service
public class PermissaoPessoaServico {
    
    @Autowired
    private PermissaoPessoaRepositorio permissaoPessoaRepositorio;
    @Autowired
    private PermissaoRepositorio permissaoRepositorio;

    public void vincularPermissao(Pessoa pessoa) {
        List<Permissao> listaPermissoes = permissaoRepositorio.findByNome("cliente");
        if (listaPermissoes.size() > 0) {
            PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
            permissaoPessoa.setPessoa(pessoa);
            permissaoPessoa.setPermissao(listaPermissoes.get(0));
        }
    }

    public List<PermissaoPessoa> listarPermissaoPessoas(){
        return permissaoPessoaRepositorio.findAll();
    }

    public PermissaoPessoa inserirPermissaoPessoa(PermissaoPessoa permissaoPessoa){
        permissaoPessoa.setDataCriacao(new Date());
        PermissaoPessoa permissaoPessoaNova = permissaoPessoaRepositorio.saveAndFlush(permissaoPessoa);
        return permissaoPessoaNova;
    }

    public PermissaoPessoa atualizarPermissaoPessoa(PermissaoPessoa permissaoPessoa){
        permissaoPessoa.setDataAtualizacao((new Date()));
        PermissaoPessoa permissaoPessoaAtualizada = permissaoPessoaRepositorio.saveAndFlush(permissaoPessoa);
        return permissaoPessoaAtualizada;
    }

    public void excluirPermissaoPessoa(Long id){
        PermissaoPessoa permissaoPessoa = permissaoPessoaRepositorio.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Permissão pessoa não encontrada."));
        permissaoPessoaRepositorio.delete(permissaoPessoa);
    }
}
