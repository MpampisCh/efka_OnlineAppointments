package org.team1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.team1.exceptions.ClientAmkaExistsException;
import org.team1.exceptions.ClientEmailExistsAdvise;
import org.team1.exceptions.ClientEmailExistsException;
import org.team1.exceptions.ClientParamsException;
import org.team1.models.Client;
import org.team1.repositories.ClientRepository;

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

    public boolean validUserEmail(Client client) {
        return clientRepository.findClientByEmailEquals(client.getEmail()) == null;
    }

    public boolean validUserAmka(Client client) {
        return clientRepository.findClientByAmkaEquals(client.getAmka()) == null;
    }

    public Client checkIfUserCanMakeRegistration(Client client) throws ClientEmailExistsException, ClientAmkaExistsException, ClientParamsException {

        if (validUserAmka(client) && validUserEmail(client)) {
            registerClient(client);
            return client;
       } else if (!validUserEmail(client) && validUserAmka(client)) {
            throw new ClientEmailExistsException(client.getEmail());
        }else if (validUserEmail(client) && !validUserAmka(client)) {
            throw new ClientAmkaExistsException(client.getAmka());
        }else {
            throw new ClientParamsException();
        }
    }

}
