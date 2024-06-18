package com.exo2.Exercice2.mapper;

import com.exo2.Exercice2.dto.AdresseDto;
import com.exo2.Exercice2.entity.Adresse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdresseMapper {
    AdresseDto toDto(Adresse adresse);
    Adresse toEntity(AdresseDto adresseDto);
    List<AdresseDto> toDtos(List<Adresse> adresses);
    List<Adresse> toEntities(List<AdresseDto> adressesDto);
}
