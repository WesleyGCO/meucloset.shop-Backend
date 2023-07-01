package meuclosetshop.backend.servico;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuclosetshop.backend.entidade.Estado;
import meuclosetshop.backend.repositorio.EstadoRepositorio;

@Service
public class EstadoServico {
    @Autowired
    private EstadoRepositorio estadoRepositorio;

    public List<Estado> listarTodosEstados(){
        return estadoRepositorio.findAll();
    }

    public Estado inserirEstado(Estado estado){
        estado.setDataCriacao(new Date());
        Estado estadoNovo = estadoRepositorio.saveAndFlush(estado);
        return estadoNovo;
    }

    public Estado atualizarEstado(Estado estado){
        estado.setDataAtualizacao(new Date());
        Estado estadoAtualizado = estadoRepositorio.saveAndFlush(estado);
        return estadoAtualizado;
    }

    public void excluirEstado(Long id){
        Estado estadoExcluido = estadoRepositorio.findById(id).get();
        estadoRepositorio.delete(estadoExcluido);
    }
}
