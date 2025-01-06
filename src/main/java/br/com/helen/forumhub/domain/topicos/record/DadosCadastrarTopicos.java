package br.com.helen.forumhub.domain.topicos.record;

import java.io.ObjectInputFilter.Status;
import java.time.LocalDateTime;

import br.com.helen.forumhub.domain.autores.Autor;
import br.com.helen.forumhub.domain.curso.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastrarTopicos(@NotBlank String titulo,
                                    @NotNull Autor autor,
                                    LocalDateTime data_criacao,
                                    @NotBlank String mensagem,
                                    @NotNull Status status,
                                    @NotNull Curso curso) {
    
}
