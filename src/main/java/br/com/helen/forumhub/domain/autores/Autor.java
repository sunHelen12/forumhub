package br.com.helen.forumhub.domain.autores;

import br.com.helen.forumhub.domain.autores.record.DadosCadastrarAutor;
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
    private String user;
    private String email;

    public Autor (DadosCadastrarAutor dados){
        this.user = dados.user();
        this.email = dados.email();
    }
}
