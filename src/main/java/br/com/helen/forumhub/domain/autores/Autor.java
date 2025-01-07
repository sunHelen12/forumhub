package br.com.helen.forumhub.domain.autores;

import br.com.helen.forumhub.domain.autores.record.DadosAutor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "autores")
@Entity(name = "Autor")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    public Autor(DadosAutor dados){
        this.nome = dados.nome();
        this.email = dados.email();
    }
}
