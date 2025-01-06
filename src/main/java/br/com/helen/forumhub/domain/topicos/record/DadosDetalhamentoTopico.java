package br.com.helen.forumhub.domain.topicos.record;

import java.time.LocalDateTime;

import br.com.helen.forumhub.domain.autores.Autor;
import br.com.helen.forumhub.domain.curso.Curso;
import br.com.helen.forumhub.domain.topicos.Status;
import br.com.helen.forumhub.domain.topicos.Topico;

public record DadosDetalhamentoTopico(Long id,
                                    Autor autor,
                                    String titulo,
                                    String mensagem,
                                    Status status,
                                    Curso curso,
                                    LocalDateTime dataCriacao) {


    public DadosDetalhamentoTopico(Topico topico){
        this(topico.getId(), topico.getAutor(), topico.getTitulo(), topico.getMensagem(), topico.getStatus(), topico.getCurso(),topico.getDataCriacao());
    }
    
}
