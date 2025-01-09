package br.com.helen.forumhub.domain.topicos.record;

import java.time.LocalDateTime;

import br.com.helen.forumhub.domain.autores.Autor;
import br.com.helen.forumhub.domain.curso.Curso;
import br.com.helen.forumhub.domain.topicos.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastrarTopicos(@NotNull Autor autor,
                                    @NotBlank String titulo,
                                    LocalDateTime dataCriacao,
                                    @NotBlank String mensagem,
                                    @NotNull Status status,
                                    @NotNull Curso curso) {
    
}
