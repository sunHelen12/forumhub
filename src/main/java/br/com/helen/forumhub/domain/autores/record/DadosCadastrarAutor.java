package br.com.helen.forumhub.domain.autores.record;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarAutor(@NotBlank String user, @NotBlank @Email String email) {
    
}
