package com.exo2.Exercice2.controller;

import com.exo2.Exercice2.dto.AdresseDto;
import com.exo2.Exercice2.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adresses")
public class AdresseController {
    @Autowired
    private AdresseService adresseService;

    @GetMapping("/{id}")
    public ResponseEntity<AdresseDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(adresseService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<AdresseDto>> findAll()
    {
        return ResponseEntity.ok(adresseService.findAll());
    }

    @GetMapping("/findBy")
    public ResponseEntity<List<AdresseDto>> findBy(@RequestParam String ville) {
        return ResponseEntity.ok(adresseService.findByVille(ville));
    }
}
