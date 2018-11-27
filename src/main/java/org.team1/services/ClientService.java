package org.team1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.team1.models.Client;
import org.team1.repositories.ClientRepository;

import java.security.Principal;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ClientService(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Client findByUserName(String username){
        return clientRepository.findByUsername(username);
    }

    public Client registerClient(Client client) {
        Client newClient = new Client();
        newClient.setFirstName(client.getFirstName());
        newClient.setLastName(client.getLastName());
        newClient.setAmka(client.getAmka());
        newClient.setPhone(client.getPhone());
        newClient.setEmail(client.getEmail());
        newClient.setUsername(client.getUsername());
        newClient.setPassword(passwordEncoder.encode(client.getPassword()));

        clientRepository.save(newClient);

        return newClient;
    }
}
