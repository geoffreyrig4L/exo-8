package com.exo2.Exercice2.controller;

import com.exo2.Exercice2.dto.EtudiantDto;
import com.exo2.Exercice2.entity.Etudiant;
import com.exo2.Exercice2.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @GetMapping
    public ResponseEntity<List<EtudiantDto>> findAll()
    {
        return ResponseEntity.ok(etudiantService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtudiantDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(etudiantService.findById(id));
    }

    @GetMapping("/findBy")
    public ResponseEntity<EtudiantDto> findBy(@RequestParam String nom, @RequestParam String prenom) {
        return ResponseEntity.ok(etudiantService.findOneByNomAndPrenom(nom, prenom));
    }

    @PostMapping
    public ResponseEntity<EtudiantDto> save(@RequestBody EtudiantDto etudiantDto) {
        return ResponseEntity.ok(etudiantService.save(etudiantDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtudiantDto> update(@PathVariable Long id, @RequestBody EtudiantDto etudiantDto) {
        return ResponseEntity.ok(etudiantService.update(id, etudiantDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        etudiantService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
