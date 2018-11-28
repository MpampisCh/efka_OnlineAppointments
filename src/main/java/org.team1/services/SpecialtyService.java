package org.team1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.team1.models.Specialty;
import org.team1.repositories.SpecialtyRepository;
import java.util.List;

@Service
public class SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    @Autowired
    public SpecialtyService(SpecialtyRepository specialtyRepository){
        this.specialtyRepository = specialtyRepository;
    }


    public List<Specialty> findAllSpecialties(){ return specialtyRepository.findAll(); }

    public Specialty saveSpec(Specialty specialty){ return specialtyRepository.save(specialty); }

    public Specialty findSpecBySpecName(String specName){
        return specialtyRepository.findByName(specName);
    }



}
