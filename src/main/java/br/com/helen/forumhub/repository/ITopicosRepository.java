package br.com.helen.forumhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.helen.forumhub.domain.topicos.Topico;

public interface ITopicosRepository extends JpaRepository<Topico, Long>{
    
}
