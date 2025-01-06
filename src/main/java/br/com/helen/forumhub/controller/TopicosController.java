package br.com.helen.forumhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.helen.forumhub.domain.topicos.DadosCadastroTopicos;
import br.com.helen.forumhub.domain.topicos.DadosDetalhamentoTopicos;
import br.com.helen.forumhub.domain.topicos.Topicos;
import br.com.helen.forumhub.repository.ITopicosRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("topicos")
public class TopicosController {
    @Autowired
    private ITopicosRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTopicos(@RequestBody @Valid DadosCadastroTopicos dados, UriComponentsBuilder uBuilder){
        var topicos = new Topicos(dados);
        repository.save(topicos);

        var uri = uBuilder.path("/topicos/{id}").buildAndExpand(topicos.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopicos(topicos));
    }

}
