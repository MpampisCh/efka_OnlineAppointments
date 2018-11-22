package org.team1.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.team1.exceptions.UserNotFoundException;
import org.team1.models.Client;
import org.team1.models.Doctor;
import org.team1.repositories.ClientRepository;
import org.team1.repositories.DoctorRepository;
import org.team1.security.MyUserDetails;

import java.util.HashSet;
import java.util.Set;

import static org.team1.Acronyms.CLIENTACRONYM;
import static org.team1.Acronyms.DOCTORACRONYM;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final ClientRepository clientRepository;
    private final DoctorRepository doctorRepository;


    @Autowired
    public MyUserDetailsService(ClientRepository clientRepository, DoctorRepository doctorRepository) {
        this.clientRepository = clientRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {

        if (username.startsWith(DOCTORACRONYM.toString())){
            String name = username.replaceFirst("D\t", "");
            Doctor doctor = doctorRepository.findByUsername(name);
            Client client = null;
            return new MyUserDetails(doctor, client);
        }else if (username.startsWith(CLIENTACRONYM.toString())){
            String name = username.replaceFirst("C\t", "");
            Client client = clientRepository.findByUsername(name);
            Doctor doctor = null;
            return new MyUserDetails(doctor, client);
        }else {
            throw new UserNotFoundException();
        }
    }
}
