package br.com.helen.forumhub.domain.topicos;

import br.com.helen.forumhub.domain.curso.Curso;
import br.com.helen.forumhub.domain.usuario.Usuario;

public record DadosDetalhamentoTopicos(Long id,
                                       String titulo,
                                       String mensagem,
                                       Status status,
                                       Usuario usuario,
                                       Curso curso                                       
                                        ) {

    public DadosDetalhamentoTopicos(Topicos topicos) {
        this(topicos.getId(), topicos.getTitulo(), topicos.getMensagem(), topicos.getStatus(),
         topicos.getUsuario(), topicos.getCurso());    
    }

}
