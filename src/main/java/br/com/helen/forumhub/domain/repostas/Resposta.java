package br.com.helen.forumhub.domain.repostas;

import java.time.LocalDateTime;

import br.com.helen.forumhub.domain.autores.Autor;
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
@Entity(name = "Reposta")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "topicos", nullable = false)
    private Topico topico;
    @Column(name = "dataCriacao", nullable = false)
    private LocalDateTime dataCriacao;
    @ManyToOne
    @JoinColumn(name = "autor", nullable = false)
    private Autor autor;
}
