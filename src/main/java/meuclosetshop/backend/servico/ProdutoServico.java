package meuclosetshop.backend.servico;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import meuclosetshop.backend.entidade.Produto;

import meuclosetshop.backend.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {
    @Autowired

    private ProdutoRepositorio produtoRepositorio;

    public List<Produto> listarTodos() {
        return produtoRepositorio.findAll();
    }

    public Produto inserir(Produto produto) {
        produto.setDataCriacao(new Date());
        Produto produtoNovo = produtoRepositorio.saveAndFlush(produto);
        return produtoNovo;
    }

    public Produto atualizar(Produto produto) {
        produto.setDataAtualizacao(new Date());
        Produto produtoAtualizado = produtoRepositorio.saveAndFlush(produto);
        return produtoAtualizado;
    }

    public void excluir(Long id) {
        Produto produto = produtoRepositorio.findById(id).get();
        produtoRepositorio.delete(produto);
    }
}
