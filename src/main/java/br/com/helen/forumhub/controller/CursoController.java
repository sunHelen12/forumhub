package br.com.helen.forumhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.helen.forumhub.domain.curso.Curso;
import br.com.helen.forumhub.domain.curso.record.DadosCadastrarCurso;
import br.com.helen.forumhub.domain.curso.record.DadosDetalhamantoCurso;
import br.com.helen.forumhub.repository.ICursoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("cursos")
public class CursoController {
    
    @Autowired
    private ICursoRepository repository;

    public ResponseEntity cadastroCurso(@RequestBody @Valid DadosCadastrarCurso dados, UriComponentsBuilder uBuilder){
         var curso = new Curso(dados); 
        repository.save(curso);

        var uri = uBuilder.path("/autores/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamantoCurso(curso));
    }
}
