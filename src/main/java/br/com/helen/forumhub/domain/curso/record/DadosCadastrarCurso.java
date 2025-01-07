package br.com.helen.forumhub.domain.curso.record;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarCurso(@NotBlank String nome, @NotBlank String categoria) {
    
}
