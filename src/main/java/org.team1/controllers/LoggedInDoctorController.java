package org.team1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.team1.exceptions.NoLoggedInClientException;
import org.team1.models.Doctor;
import org.team1.repositories.DoctorRepository;

import java.security.Principal;

public class LoggedInDoctorController {

    private final DoctorRepository doctorRepository;

    @Autowired
    public LoggedInDoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    @GetMapping("/doctor")
    public Doctor getLoggedInClient(Principal principal) {
        if (principal == null) {
            throw new NoLoggedInClientException();
        } else {
            Doctor loggedInUser = doctorRepository.findByUsername(principal.getName());
            return loggedInUser;
        }
    }
}
