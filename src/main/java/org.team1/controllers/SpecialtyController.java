package org.team1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.team1.exceptions.SpecialtyNotFoundException;
import org.team1.models.Specialty;
import org.team1.repositories.SpecialtyRepository;
import org.team1.services.SpecialtyService;

import java.util.List;

@RestController
public class SpecialtyController {

    private final SpecialtyRepository specialtyRepository;
    private final SpecialtyService specialtyService;

    @Autowired
    public SpecialtyController(SpecialtyRepository specialtyRepository, SpecialtyService specialtyService) {
        this.specialtyRepository = specialtyRepository;
        this.specialtyService = specialtyService;
    }

    @GetMapping("/specialty/all")
    public List<Specialty> getSpecialty() {
        return specialtyService.findAllSpecialties();
    }

    @GetMapping("/specialty/{name}")
    public Specialty getSpecialty(@PathVariable String specName) {
        return specialtyService.findSpecBySpecName(specName);
    }

    @PostMapping("/specialty")
    public Specialty newSpecialty(@RequestBody Specialty specialty) {
        return specialtyService.saveSpec(specialty);
    }

    @PutMapping("/specialty/{id}")
    public Specialty updateSpecialty(@PathVariable Long id, @RequestBody Specialty updateSpecialty) {
        return specialtyRepository.findById(id)
                .map(specialty -> {
                    specialty.setName(updateSpecialty.getName());
                    return specialtyRepository.save(specialty);
                })
                .orElseThrow(() -> new SpecialtyNotFoundException(id));
    }

    @DeleteMapping("specialty/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteSpecialty(@PathVariable String name) {
        getSpecialty(name);
        specialtyRepository.deleteByName(name);
    }
}
