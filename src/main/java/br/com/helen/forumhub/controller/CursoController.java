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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.helen.forumhub.domain.curso.Curso;
import br.com.helen.forumhub.domain.curso.record.DadosCadastrarCurso;
import br.com.helen.forumhub.domain.curso.record.DadosDetalhamentoCurso;
import br.com.helen.forumhub.repository.ICursoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("cursos")
public class CursoController {
    
    @Autowired
    private ICursoRepository cursoRepository;

    //cadastra curso
    @PostMapping
    @Transactional
    public ResponseEntity cadastroCurso(@RequestBody @Valid DadosCadastrarCurso dados, UriComponentsBuilder uBuilder){
         var curso = new Curso(dados); 
         cursoRepository.save(curso);

        var uri = uBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCurso(curso));
    }
    //lista curso
     @GetMapping
    public ResponseEntity <Page<DadosDetalhamentoCurso>>listarAutores(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao){
        var page = cursoRepository.findAll(paginacao).map(DadosDetalhamentoCurso::new);
        return ResponseEntity.ok(page);
    }
    //apaga curso
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirCurso(@PathVariable Long id){
        cursoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    //detalha curso por id
     @GetMapping("/{id}")
    public ResponseEntity detalharTopico(@PathVariable Long id){
        var curso = cursoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoCurso(curso));
    }
}
