package br.com.helen.forumhub.domain.autores.record;

import br.com.helen.forumhub.domain.autores.Autor;

public record DadosAutor(Long id, String nome, String email) {

    public DadosAutor(Autor autor){
        this(autor.getId(), autor.getNome(), autor.getEmail());
    }
}
