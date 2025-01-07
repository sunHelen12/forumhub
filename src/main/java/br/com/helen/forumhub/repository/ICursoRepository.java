package br.com.helen.forumhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.helen.forumhub.domain.curso.Curso;

public interface ICursoRepository extends JpaRepository <Curso, Long> {
    
}
