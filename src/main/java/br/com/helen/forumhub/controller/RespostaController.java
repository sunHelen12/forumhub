package br.com.helen.forumhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.helen.forumhub.domain.repostas.Resposta;
import br.com.helen.forumhub.domain.repostas.record.DadosCadastrarRespostas;
import br.com.helen.forumhub.domain.repostas.record.DadosDetalhamentoRespostas;
import br.com.helen.forumhub.repository.IRespostaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("respostas")
public class RespostaController {

    @Autowired
    private IRespostaRepository respostaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarResposta(@RequestBody @Valid DadosCadastrarRespostas dados, UriComponentsBuilder uBuilder){
        var resposta = new Resposta(dados); 
        respostaRepository.save(resposta);

        var uri = uBuilder.path("/topicos/{id}").buildAndExpand(resposta.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoRespostas(resposta));
    }


    
}
