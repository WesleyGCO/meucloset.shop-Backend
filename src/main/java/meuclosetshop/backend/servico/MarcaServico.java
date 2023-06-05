package meuclosetshop.backend.servico;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuclosetshop.backend.entidade.Marca;
import meuclosetshop.backend.repositorio.MarcaRepositorio;

@Service
public class MarcaServico {
    
    @Autowired
    private MarcaRepositorio marcaRepositorio;

    public List<Marca> listarTodos(){
        return marcaRepositorio.findAll();
    }

    public Marca inserir(Marca marca){
        marca.setDataCriacao(new Date());
        Marca marcaNovo = marcaRepositorio.saveAndFlush(marca);
        return marcaNovo;
    }

    public Marca atualizar(Marca marca){
        marca.setDataAtualizacao(new Date());
        Marca marcaAtualizado = marcaRepositorio.saveAndFlush(marca);
        return marcaAtualizado;
    }

    public void excluir(Long id){
        Marca marca = marcaRepositorio.findById(id).get();
        marcaRepositorio.delete(marca);
    }
}
