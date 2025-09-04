package com.senac.projeto3.repository;

import com.senac.projeto3.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u WHERE u.status >=0")
    List<Usuario> listarUsuariosAtivos();

    @Query("SELECT u FROM Usuario u WHERE u.id = :id AND u.status >= 0")
    Usuario obterUsuarioAtivoPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query("UPDATE Usuario u SET u.status = -1 WHERE u.id = :id")
    int apagadorLogico(@Param("id") int id);
}
