package br.com.helen.forumhub.domain.repostas.record;

import br.com.helen.forumhub.domain.topicos.Topico;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarRespostas(Topico topico, @NotBlank String solucao) {
    
}
