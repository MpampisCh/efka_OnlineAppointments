package org.team1.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.team1.exceptions.ClientNotFoundException;
import org.team1.models.Client;

import org.team1.repositories.ClientRepository;

import javax.persistence.Id;
import java.util.List;

@RestController
public class ClientController {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @GetMapping("/clients")
    public List<Client> getClient(Integer amka) {
        return clientRepository.findAll();
    }

    @GetMapping("/clients/{amka}")
    public Client getSpecialty(@PathVariable Integer amka) {
        return clientRepository.findById(amka)
                .orElseThrow(() -> new ClientNotFoundException(amka));
    }

    @PostMapping("/clients")
    public Client newClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @PutMapping("/clients/{amka}")
    public Client updateClient(@PathVariable Integer amka, @RequestBody Client updateClient) {
        return clientRepository.findById(amka)
                .map(client -> {
                    client.setUsername(updateClient.getUsername());
                    return clientRepository.save(client);
                })
                .orElseThrow(() -> new ClientNotFoundException(amka));
    }

    @DeleteMapping("clients/{amka}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Integer amka) {
        getClient(amka);
        clientRepository.deleteById(amka);
    }
}

