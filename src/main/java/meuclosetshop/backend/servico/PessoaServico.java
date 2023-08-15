package meuclosetshop.backend.servico;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuclosetshop.backend.entidade.Pessoa;
import meuclosetshop.backend.repositorio.PessoaRepositorio;

@Service
public class PessoaServico {
    
    @Autowired
    private PessoaRepositorio pessoaRepositorio;

    public List<Pessoa> listarTodasPessoas(){
        return pessoaRepositorio.findAll();
    }

    public Pessoa inserirPessoa(Pessoa pessoa){
        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNova = pessoaRepositorio.saveAndFlush(pessoa);
        return pessoaNova;
    }

    public Pessoa atualizarPessoa(Pessoa pessoa){
        pessoa.setDataAtualizacao((new Date()));
        Pessoa pessoaAtualizada = pessoaRepositorio.saveAndFlush(pessoa);
        return pessoaAtualizada;
    }

    public void excluirPessoa(Long id){
        Pessoa pessoa = pessoaRepositorio.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Pessoa não encontrada."));
        pessoaRepositorio.delete(pessoa);
    }

    public List<Pessoa> findByCidade_id(Long idCidade){
        return pessoaRepositorio.findByCidade_id(idCidade);
    }
}
