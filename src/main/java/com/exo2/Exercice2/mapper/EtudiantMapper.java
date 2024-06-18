package com.exo2.Exercice2.mapper;

import com.exo2.Exercice2.dto.EtudiantDto;
import com.exo2.Exercice2.entity.Etudiant;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = ProjetMapper.class)
public interface EtudiantMapper {
    // Single Object
    Etudiant toEntity(EtudiantDto etudiantDto);
    @Mapping(target = "projets.etudiants", ignore = true)
    EtudiantDto toDto(Etudiant etudiant);
    // List of Objects
    List<Etudiant> toEntities(List<EtudiantDto> etudiantsDto);

    List<EtudiantDto> toDtos(List<Etudiant> etudiants);

}
