package br.com.helen.forumhub.domain.curso.record;

import br.com.helen.forumhub.domain.curso.Curso;

public record DadosCurso(Long id, String nome, String categoria) {
    public DadosCurso(Curso curso){
        this(curso.getId(), curso.getNome(), curso.getCategoria());
    }
}
