package com.exo2.Exercice2.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String nom;
    private String prenom;
    List<ProjetDto> projets;
}
