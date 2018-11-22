package org.team1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.team1.repositories.SpecialtyRepository;

@Service
public class SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    @Autowired
    public SpecialtyService(SpecialtyRepository specialtyRepository){
        this.specialtyRepository = specialtyRepository;
    }


}
