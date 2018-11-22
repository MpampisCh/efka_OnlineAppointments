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
        client.setFirstName(newClient.getFirstName());
        client.setLastName(newClient.getLastName());
        client.setAmka(newClient.getAmka());
        client.setPhone(newClient.getPhone());
        client.setEmail(newClient.getEmail());
        client.setUsername(newClient.getUsername());
        client.setPassword(newClient.getPassword());

        clientRepository.save(client);

        return newClient;
    }
}
