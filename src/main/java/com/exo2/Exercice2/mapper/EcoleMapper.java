package com.exo2.Exercice2.mapper;

import com.exo2.Exercice2.dto.EcoleDto;
import com.exo2.Exercice2.entity.Ecole;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EtudiantMapper.class})
public interface EcoleMapper {
    // Single Object
    Ecole toEntity(EcoleDto ecoleDto);
    EcoleDto toDto(Ecole ecole);
    // List of objects
    List<Ecole> toEntities(List<EcoleDto> ecoleDtos);
    List<EcoleDto> toDtos(List<Ecole> ecoles);
}
