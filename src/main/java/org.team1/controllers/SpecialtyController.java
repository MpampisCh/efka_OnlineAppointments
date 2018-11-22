package org.team1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.team1.exceptions.SpecialtyNotFoundException;
import org.team1.models.Specialty;
import org.team1.repositories.SpecialtyRepository;

import java.util.List;

@RestController
public class SpecialtyController {

    private final SpecialtyRepository specialtyRepository;

    @Autowired
    public SpecialtyController(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @GetMapping("/specialties")
    public List<Specialty> getSpecialty() {
        return specialtyRepository.findAll();
    }

    @GetMapping("/specialties/{id}")
    public Specialty getSpecialty(@PathVariable Long id) {
        return specialtyRepository.findById(id)
                .orElseThrow(() -> new SpecialtyNotFoundException(id));
    }

    //todo: get list of doctors with this specialty

    @PostMapping("/specialties")
    public Specialty newSpecialty(@RequestBody Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @PutMapping("/specialties/{id}")
    public Specialty updateSpecialty(@PathVariable Long id, @RequestBody Specialty updateSpecialty) {
        return specialtyRepository.findById(id)
                .map(specialty -> {
                    specialty.setName(updateSpecialty.getName());
                    return specialtyRepository.save(specialty);
                })
                .orElseThrow(() -> new SpecialtyNotFoundException(id));
    }

    @DeleteMapping("specialties/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteSpecialty(@PathVariable Long id) {
        getSpecialty(id);
        specialtyRepository.deleteById(id);
    }
}
