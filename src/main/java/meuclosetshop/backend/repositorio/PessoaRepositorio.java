package meuclosetshop.backend.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import meuclosetshop.backend.entidade.Pessoa;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Long>{
    public List<Pessoa> findByCidade_id(Long idCidade);
}
