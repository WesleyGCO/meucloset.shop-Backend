package meuclosetshop.backend.servico;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuclosetshop.backend.entidade.Cidade;
import meuclosetshop.backend.repositorio.CidadeRepositorio;

@Service
public class CidadeServico {
    @Autowired
    private CidadeRepositorio cidadeRepositorio;

    public List<Cidade> listarTodasCidades(){
        return cidadeRepositorio.findAll();
    }

    public Cidade inserirCidade(Cidade cidade){
        cidade.setDataCriacao(new Date());
        Cidade cidadeNova = cidadeRepositorio.saveAndFlush(cidade);
        return cidadeNova;
    }

    public Cidade atualizarCidade(Cidade cidade){
        cidade.setDataAtualizacao(new Date());
        Cidade cidadeAtualizada = cidadeRepositorio.save(cidade);
        return cidadeAtualizada;
    }

    public void excluirCidade(Long id){
        Cidade cidadeExcluida = cidadeRepositorio.findById(id).get();
        cidadeRepositorio.delete(cidadeExcluida);
    }
}
