package com.WildLife.Wild.repository;

import com.WildLife.Wild.entities.FuncionariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<FuncionariosEntity, Long> {
    Optional<FuncionariosEntity> findByEmail(String email);
}


