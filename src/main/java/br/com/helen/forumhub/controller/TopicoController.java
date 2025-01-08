package br.com.helen.forumhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.helen.forumhub.domain.topicos.Topico;
import br.com.helen.forumhub.domain.topicos.record.DadosCadastrarTopicos;
import br.com.helen.forumhub.domain.topicos.record.DadosDetalhamentoTopico;
import br.com.helen.forumhub.repository.ITopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private ITopicoRepository topicoRepository;
       
    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTopico(@RequestBody @Valid DadosCadastrarTopicos dados, UriComponentsBuilder uBuilder){
        
        var topicos = new Topico(dados); 
        topicoRepository.save(topicos);

        var uri = uBuilder.path("/topicos/{id}").buildAndExpand(topicos.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topicos));

    }

    @GetMapping
    public ResponseEntity <Page<DadosDetalhamentoTopico>>listarAutores(@PageableDefault(size = 10, sort = {"id"})Pageable paginacao){
        var page = topicoRepository.findAll(paginacao).map(DadosDetalhamentoTopico::new);
        return ResponseEntity.ok(page);
    }

    
}
