package com.exo2.Exercice2.mapper;

import com.exo2.Exercice2.dto.ProjetDto;
import com.exo2.Exercice2.entity.Projet;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProjetMapper {

    ProjetDto toDto(Projet projet);

    Projet toEntity(ProjetDto projetDto);

    List<ProjetDto> toDtos(List<Projet> projets);

    List<Projet> toEntities(List<ProjetDto> projetDtos);
}
