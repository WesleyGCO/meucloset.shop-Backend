package meuclosetshop.backend.servico;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import meuclosetshop.backend.entidade.Categoria;
import meuclosetshop.backend.repositorio.CategoriaRepositorio;

@Service
public class CategoriaServico {
    @Autowired

    private CategoriaRepositorio categoriaRepositorio;

    public List<Categoria> listarTodos() {
        return categoriaRepositorio.findAll();
    }

    public Categoria inserir(Categoria categoria) {
        categoria.setDataCriacao(new Date());
        Categoria categoriaNovo = categoriaRepositorio.saveAndFlush(categoria);
        return categoriaNovo;
    }

    public Categoria atualizar(Categoria categoria) {
        categoria.setDataAtualizacao(new Date());
        Categoria categoriaAtualizado = categoriaRepositorio.saveAndFlush(categoria);
        return categoriaAtualizado;
    }

    public void excluir(Long id) {
        Categoria categoria = categoriaRepositorio.findById(id).get();
        categoriaRepositorio.delete(categoria);
    }
}
