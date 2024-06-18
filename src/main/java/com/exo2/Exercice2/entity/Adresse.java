package com.exo2.Exercice2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

@Entity
@Table(name = "adresse", indexes = @Index(name = "idx_ville", columnList = "ville"))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adresse_id")
    private Long id;

    @Column(name = "ville")
    private String ville;
    private String complementAdresse;
    private int codePostal;

    @OneToOne(mappedBy = "adresse")
    private Ecole ecole;
}
