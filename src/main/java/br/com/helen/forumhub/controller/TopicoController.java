package br.com.helen.forumhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.helen.forumhub.domain.topicos.Topico;
import br.com.helen.forumhub.domain.topicos.record.DadosAtualizacaoTopicos;
import br.com.helen.forumhub.domain.topicos.record.DadosCadastrarTopicos;
import br.com.helen.forumhub.domain.topicos.record.DadosDetalhamentoTopico;
import br.com.helen.forumhub.repository.ITopicoRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private ITopicoRepository topicoRepository;
    
    //cadastrar topico
    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTopico(@RequestBody @Valid DadosCadastrarTopicos dados, UriComponentsBuilder uBuilder){
        
        var topicos = new Topico(dados); 
        topicoRepository.save(topicos);

        var uri = uBuilder.path("/topicos/{id}").buildAndExpand(topicos.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topicos));

    }
    //listar topicos
    @GetMapping
    public ResponseEntity <Page<DadosDetalhamentoTopico>>listarAutores(@PageableDefault(size = 10, sort = {"id"})Pageable paginacao){
        var page = topicoRepository.findAll(paginacao).map(DadosDetalhamentoTopico::new);
        return ResponseEntity.ok(page);
    }
    //atualizar topicos
    @PutMapping
    @Transactional
    public ResponseEntity atualizarTopico(@RequestBody @Valid DadosAtualizacaoTopicos dados){
        var topicoOptional = topicoRepository.findById(dados.id());
    
        if (!topicoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        var topico = topicoOptional.get(); 
        topico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }    
    //detalhar topico por id
    @GetMapping("/{id}")
    public ResponseEntity detalharTopico(@PathVariable Long id){
        var topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }
    //excluir topico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirCurso(@PathVariable Long id){

        var topicoOptional = topicoRepository.findById(id);
        
        if (!topicoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }        
        
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
