package com.aqui.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aqui.backend.models.Usuario;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    List<Usuario> findByIdIn(List<Long> ids);

    List<Usuario> findByEmail(String email);
    
    //Usuario findById(Long id);

}
