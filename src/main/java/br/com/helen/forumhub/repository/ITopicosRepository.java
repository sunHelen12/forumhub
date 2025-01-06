package br.com.helen.forumhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.helen.forumhub.domain.topicos.Topicos;

public interface ITopicosRepository extends JpaRepository<Topicos,Long> {

}
