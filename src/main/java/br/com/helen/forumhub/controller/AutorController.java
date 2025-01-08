package br.com.helen.forumhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.helen.forumhub.domain.autores.Autor;
import br.com.helen.forumhub.domain.autores.record.DadosCadastrarAutor;
import br.com.helen.forumhub.domain.autores.record.DadosDetalhamentoAutor;
import br.com.helen.forumhub.repository.IAutorRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("autores")
public class AutorController {
    @Autowired
    private IAutorRepository autorRepository;

    //cadstra autor
    @PostMapping
    @Transactional
     public ResponseEntity cadastrarAutor(@RequestBody @Valid DadosCadastrarAutor dados, UriComponentsBuilder uBuilder){
        var autor = new Autor(dados); 
        autorRepository.save(autor);

        var uri = uBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAutor(autor));
    }
    //apaga autor
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirCurso(@PathVariable Long id){
        autorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    

}
