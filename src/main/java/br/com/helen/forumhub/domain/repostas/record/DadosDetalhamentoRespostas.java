package br.com.helen.forumhub.domain.repostas.record;

import br.com.helen.forumhub.domain.repostas.Resposta;

public record DadosDetalhamentoRespostas(String solucao) {

    public DadosDetalhamentoRespostas(Resposta resposta) {
        this(resposta.getSolucao());
    }
    
}
