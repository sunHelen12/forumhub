package br.com.helen.forumhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.helen.forumhub.domain.topicos.Topico;
import br.com.helen.forumhub.domain.topicos.record.DadosCadastrarTopicos;
import br.com.helen.forumhub.repository.ITopicoRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private ITopicoRepository repository;
    
    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTopico(@RequestBody DadosCadastrarTopicos dados, UriComponentsBuilder uBuilder){
        var topicos = new Topico(dados); 
        repository.save(topicos);

        var uri = uBuilder.path("/topicos/{id}").buildAndExpand(topicos.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topicos));

    }
}
