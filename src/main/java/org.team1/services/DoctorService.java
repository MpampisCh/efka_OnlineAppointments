package org.team1.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.team1.models.Doctor;
import org.team1.repositories.DoctorRepository;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    public Doctor findDoctorByAmka(long amka){
        return doctorRepository.findByAmka(amka);
    }

    public List<Doctor> getDoctorsWithSpecialty(String specName){
        return doctorRepository.findDoctorsBySpecialtyNameEquals(specName);
    }
}
