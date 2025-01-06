package br.com.helen.forumhub.domain.topicos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



import br.com.helen.forumhub.domain.autores.Autor;
import br.com.helen.forumhub.domain.curso.Curso;
import br.com.helen.forumhub.domain.repostas.Resposta;
import br.com.helen.forumhub.domain.topicos.record.DadosCadastrarTopicos;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table (name = "topicos")
@Entity(name = "Topico")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Topico {    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    @Column(name = "dataCriacao", nullable = false)
    private LocalDateTime dataCriacao;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "autor", nullable = false)
    private Autor autor;
    @OneToMany
    @JoinColumn(name = "curso", nullable = false)
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resposta> respostas  = new ArrayList<>();

    public Topico(DadosCadastrarTopicos dados) {
       this.titulo = dados.titulo();
       this.mensagem = dados.mensagem();
       this.dataCriacao = dados.dataCriacao()!= null ? dados.dataCriacao() : LocalDateTime.now();;
       this.autor = dados.autor();
       this.curso = dados.curso();
       this.respostas = new ArrayList<>();
    }


}
