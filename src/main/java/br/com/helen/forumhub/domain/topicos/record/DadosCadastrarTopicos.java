package br.com.helen.forumhub.domain.topicos.record;

import java.time.LocalDateTime;

import br.com.helen.forumhub.domain.autores.Autor;
import br.com.helen.forumhub.domain.curso.Curso;
import br.com.helen.forumhub.domain.topicos.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastrarTopicos(@NotBlank String titulo,
                                    @NotNull Autor autor,
                                    LocalDateTime dataCriacao,
                                    @NotBlank String mensagem,
                                    @NotNull Status status,
                                    @NotNull Curso curso) {
    
}
