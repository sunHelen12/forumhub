package br.com.helen.forumhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.helen.forumhub.domain.autores.Autor;

public interface IAutorRepository extends JpaRepository <Autor, Long> {
    
}
