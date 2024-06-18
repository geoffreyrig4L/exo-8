package com.exo2.Exercice2.controller;

import com.exo2.Exercice2.dto.EcoleDto;
import com.exo2.Exercice2.service.EcoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecoles")
public class EcoleController {
    @Autowired
    private EcoleService ecoleService;

    @GetMapping
    public ResponseEntity<List<EcoleDto>> findAll() {
        return ResponseEntity.ok(ecoleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EcoleDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ecoleService.findById(id));
    }

    @GetMapping("/findBy")
    public ResponseEntity<List<EcoleDto>> findByNomContainingIgnoreCase(@RequestParam String nom) {
        return ResponseEntity.ok(ecoleService.findByNomEtudiant(nom));
    }

    @PostMapping
    public ResponseEntity<EcoleDto> save(@RequestBody EcoleDto ecoleDto) {
        return ResponseEntity.ok(ecoleService.save(ecoleDto));
    }
}
