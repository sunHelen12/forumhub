package br.com.helen.forumhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.helen.forumhub.domain.repostas.Resposta;

public interface IRespostaRepository extends JpaRepository <Resposta, Long> {
    
}
