package com.exo2.Exercice2.repository;

import com.exo2.Exercice2.entity.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {
    List<Adresse> findAdresseByVille(String ville);
}
