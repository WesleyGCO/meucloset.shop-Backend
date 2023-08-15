package meuclosetshop.backend.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import meuclosetshop.backend.entidade.Permissao;

public interface PermissaoRepositorio extends JpaRepository<Permissao, Long>{
    List<Permissao> findByNome(String nome);
}
