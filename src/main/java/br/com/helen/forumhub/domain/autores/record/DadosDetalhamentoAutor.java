package br.com.helen.forumhub.domain.autores.record;

import br.com.helen.forumhub.domain.autores.Autor;

public record DadosDetalhamentoAutor(Long id, String user, String email) {

    public DadosDetalhamentoAutor(Autor autor){
        this(autor.getId(), autor.getUser(), autor.getEmail());
    }
}
