package com.senac.api.filmes_api.repository;

import com.senac.api.filmes_api.entity.GestorEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GestorRepository extends JpaRepository<GestorEntity, Integer> {
    GestorEntity findByEmailAndMatriculaAndComite(String email, String matricula, String comite);
}
