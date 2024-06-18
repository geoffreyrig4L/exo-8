package com.exo2.Exercice2.service;

import com.exo2.Exercice2.dto.EtudiantDto;
import com.exo2.Exercice2.entity.Etudiant;
import com.exo2.Exercice2.mapper.EtudiantMapper;
import com.exo2.Exercice2.repository.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;
    private final EtudiantMapper etudiantMapper;

    @Cacheable(value = "etudiants")
    public List<EtudiantDto> findAll(Pageable pageable) {
        return etudiantRepository.findAll(pageable).map(etudiantMapper::toDto).getContent();
    }

    @Cacheable(value = "etudiantById", key="#id")
    public EtudiantDto findById(Long id) {
        return etudiantMapper.toDto(etudiantRepository.findById(id).orElse(null));
    }

    @Caching(cacheable = {
            @Cacheable(value = "etudiantByNom", key = "#nom + #prenom"),
    })
    public EtudiantDto findOneByNomAndPrenom(String nom, String prenom) {
        return etudiantMapper.toDto(etudiantRepository.findOneEtudiantByNomAndPrenom(nom, prenom).orElse(null));
    }

    @Caching(evict = {
            @CacheEvict(value = "etudiantByNom", allEntries = true),
            @CacheEvict(value = "etudiantById", allEntries = true),
            @CacheEvict(value = "etudiants", allEntries = true)
    })
    public EtudiantDto save(EtudiantDto etudiantDto) {
        return etudiantMapper.toDto(etudiantRepository.save(etudiantMapper.toEntity(etudiantDto)));
    }

    @Caching(put = {
            @CachePut(value = "etudiantById", key = "#etudiantDto.id"),
            @CachePut(value = "etudiantByNom", key = "#etudiantDto.nom + #etudiantDto.prenom"),
    }, evict = @CacheEvict(value = "etudiantByNom", allEntries = true))
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

    @Caching(evict = {
            @CacheEvict(value = "etudiantByNom", allEntries = true),
            @CacheEvict(value = "etudiantById", allEntries = true),
            @CacheEvict(value = "etudiants", allEntries = true)
    })
    public void delete(Long id) {
        etudiantRepository.deleteById(id);
    }
}
