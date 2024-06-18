package com.exo2.Exercice2.service;

import com.exo2.Exercice2.dto.EtudiantDto;
import com.exo2.Exercice2.entity.Etudiant;
import com.exo2.Exercice2.mapper.EtudiantMapper;
import com.exo2.Exercice2.repository.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;
    private final EtudiantMapper etudiantMapper;

    public List<EtudiantDto> findAll() {
        return etudiantMapper.toDtos(etudiantRepository.findAll());
    }

    public EtudiantDto findById(Long id) {
        return etudiantMapper.toDto(etudiantRepository.findById(id).orElse(null));
    }

    public EtudiantDto findOneByNomAndPrenom(String nom, String prenom) {
        return etudiantMapper.toDto(etudiantRepository.findOneEtudiantByNomAndPrenom(nom, prenom).orElse(null));
    }

    public EtudiantDto save(EtudiantDto etudiantDto) {
        return etudiantMapper.toDto(etudiantRepository.save(etudiantMapper.toEntity(etudiantDto)));
    }

    public EtudiantDto update(Long id, EtudiantDto etudiantDto) {
        return etudiantRepository.findById(id)
                .map(existingEtudiant -> {
                    Etudiant etudiant = etudiantMapper.toEntity(etudiantDto);
                    etudiant.setId(id);
                    if (Objects.nonNull(existingEtudiant.getEcole())) {
                        etudiant.setEcole(existingEtudiant.getEcole());
                    }
                    if(Objects.nonNull(existingEtudiant.getProjets()) || existingEtudiant.getProjets().size() != 0) {
                        etudiant.setProjets(existingEtudiant.getProjets());
                    }
                    return etudiantMapper.toDto(etudiantRepository.save(etudiant));
                })
                .orElse(null);
    }

    public void delete(Long id) {
        etudiantRepository.deleteById(id);
    }
}
