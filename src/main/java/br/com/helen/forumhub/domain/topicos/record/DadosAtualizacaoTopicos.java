package br.com.helen.forumhub.domain.topicos.record;

import br.com.helen.forumhub.domain.topicos.Status;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopicos(@NotNull Long id, String mensagem, String titulo, Status status) {
    
}
