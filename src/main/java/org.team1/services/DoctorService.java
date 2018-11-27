package org.team1.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.team1.models.Doctor;
import org.team1.models.Specialty;
import org.team1.repositories.DoctorRepository;

import javax.print.Doc;
import java.security.Principal;
import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }
//
//    public Doctor findByUserName(String username){
//        return doctorRepository.findByUsername(username);
//    }

    public Doctor findDoctorByAmka(long amka){
        return doctorRepository.findByAmka(amka);
    }

    public List<Doctor> getDoctorsWithSpecialty(String name){
        return doctorRepository.findDoctorsBySpecialtyNameEquals(name);
    }

}
