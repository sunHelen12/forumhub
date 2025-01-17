package br.com.helen.forumhub.domain.curso.record;

import br.com.helen.forumhub.domain.curso.Curso;

public record DadosDetalhamentoCurso(Long id, String nome, String categoria) {
    public DadosDetalhamentoCurso(Curso curso){
        this(curso.getId(), curso.getNome(), curso.getCategoria());
    }
}
