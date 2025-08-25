package com.senac.projeto3.repository;

import com.senac.projeto3.entity.Categoria;
import com.senac.projeto3.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface JogoRepository  extends JpaRepository<Categoria, Integer>{
}