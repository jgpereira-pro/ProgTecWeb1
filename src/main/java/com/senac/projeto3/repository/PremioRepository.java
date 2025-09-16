package com.senac.projeto3.repository;

import com.senac.projeto3.entity.Premio;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PremioRepository extends JpaRepository <Premio, Integer>{

    @Query("SELECT p FROM Premio p WHERE p.status >=0")
    List<Premio> listarPremios();

    @Query("SELECT p FROM Premio p WHERE p.id = :id AND p.status >=0")
    Premio obterPremioAtivoPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query("UPDATE Premio p SET p.status = -1 WHERE p.id = :id")
    int apagadorLogico(@Param("id") int id);
}
