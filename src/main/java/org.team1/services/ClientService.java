package org.team1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.team1.models.Client;
import org.team1.repositories.ClientRepository;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client registerClient(Client client) {

        Client newClient = new Client();
        newClient.setFirstName(client.getFirstName());
        newClient.setLastName(client.getLastName());
        newClient.setAmka(client.getAmka());
        newClient.setPhone(client.getPhone());
        newClient.setEmail(client.getEmail());
        newClient.setUsername(client.getUsername());
        newClient.setPassword(client.getPassword());

        clientRepository.save(newClient);

        return newClient;
    }
}
