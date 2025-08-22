package com.senac.projeto3.repository;

import com.senac.projeto3.entity.Premio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremioRepository extends JpaRepository <Premio, Integer>{
}
