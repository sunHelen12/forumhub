package br.com.helen.forumhub.domain.repostas;

import java.time.LocalDateTime;

import br.com.helen.forumhub.domain.autores.Autor;
import br.com.helen.forumhub.domain.repostas.record.DadosCadastrarRespostas;
import br.com.helen.forumhub.domain.topicos.Topico;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "respostas")
@Entity(name = "Resposta")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Resposta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String solucao;
    @ManyToOne
    @JoinColumn(name = "topico", nullable = false)
    private Topico topico;
    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;
    @ManyToOne
    @JoinColumn(name = "autor", nullable = false)
    private Autor autor;

    public Resposta(DadosCadastrarRespostas dados) {
        this.topico = dados.topico();
        this.solucao = dados.solucao();
    }
}
