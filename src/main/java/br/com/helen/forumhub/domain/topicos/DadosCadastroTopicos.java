package br.com.helen.forumhub.domain.topicos;

import br.com.helen.forumhub.domain.curso.DadosCurso;
import br.com.helen.forumhub.domain.usuario.DadosUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopicos(@NotBlank
                           String titulo,
                           @NotBlank 
                           String mensagem,
                           @NotNull 
                           Status status,
                           @NotNull @Valid
                           DadosUsuario usuario, 
                           @NotNull
                           DadosCurso curso
                           ) {
}