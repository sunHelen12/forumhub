package br.com.helen.forumhub.domain.curso.record;

import br.com.helen.forumhub.domain.curso.Curso;

public record DadosDetalhamantoCurso(Long id, String nome, String categoria) {
    public DadosDetalhamantoCurso(Curso curso){
        this(curso.getId(), curso.getNome(), curso.getCategoria());
    }
}
