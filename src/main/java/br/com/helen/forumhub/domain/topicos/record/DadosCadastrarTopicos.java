package br.com.helen.forumhub.domain.topicos.record;

import java.io.ObjectInputFilter.Status;

import br.com.helen.forumhub.domain.curso.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastrarTopicos(@NotBlank String titulo,
                                    @NotBlank String mensagem,
                                    @NotNull Status status,
                                    @NotNull Curso curso) {
    
}
