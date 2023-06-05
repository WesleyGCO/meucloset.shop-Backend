package meuclosetshop.backend.entidade;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name = "produto")
public class Produto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricaoCurta")
    private String descricaoCurta;

    @Column(name = "descricaoDetalhada")
    private String descricaoDetalhada;

    @Column(name = "valorCusto")
    private double valorCusto;

    @Column(name = "valorVenda")
    private double valorVenda;

    @Column(name = "tamanho")
    private String tamanho;

    @Column(name = "cor")
    private String cor;

    @Column(name = "dataCriacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Column(name = "dataAtualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "fk_marca") // Muda o nome da FK
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "fk_categoria") // Muda o nome da FK
    private Categoria categoria;
}