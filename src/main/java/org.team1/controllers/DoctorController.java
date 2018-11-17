package org.team1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.team1.exceptions.DoctorNotFoundException;
import org.team1.models.Doctor;
import org.team1.repositories.DoctorRepository;

import java.util.List;

public class DoctorController {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorController(DoctorRepository clientRepository) {
        this.doctorRepository = clientRepository;
    }
    @GetMapping("/doctors")
    public List<Doctor> getDoctor() {
        return doctorRepository.findAll();
    }

    @GetMapping("/doctors/{amka}")
    public Doctor getDoctor(@PathVariable Integer amka) {
        return doctorRepository.findById(amka)
                .orElseThrow(() -> new DoctorNotFoundException(amka));
    }

    @PostMapping("/doctors")
    public Doctor newDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @PutMapping("/doctors/{amka}")
    public Doctor updateDoctor(@PathVariable Integer amka, @RequestBody Doctor updateDoctor) {
        return doctorRepository.findById(amka)
                .map(doctor -> {
                    doctor.setUsername(updateDoctor.getUsername());
                    return doctorRepository.save(doctor);
                })
                .orElseThrow(() -> new DoctorNotFoundException(amka));
    }

    @DeleteMapping("doctors/{amka}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteDoctor(@PathVariable Integer amka) {
        getDoctor(amka);
        doctorRepository.deleteById(amka);
    }
}

