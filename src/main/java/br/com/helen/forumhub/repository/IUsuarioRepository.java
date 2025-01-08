package br.com.helen.forumhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.helen.forumhub.domain.usuario.Usuario;

public interface IUsuarioRepository extends JpaRepository <Usuario, Long> {
    UserDetails findByLogin(String login);    

}
