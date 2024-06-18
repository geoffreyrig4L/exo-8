package com.exo2.Exercice2.repository;

import com.exo2.Exercice2.entity.Etudiant;
import com.exo2.Exercice2.entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjetRepository extends JpaRepository<Projet, Long> {
    @Query("SELECT p.etudiants FROM Projet p WHERE p.id = :projetId")
    List<Etudiant> findEtudiantsByProjetId(@Param("projetId") Long projetId);
}
