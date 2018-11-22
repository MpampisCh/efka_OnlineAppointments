package org.team1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.team1.exceptions.NoLoggedInClientException;
import org.team1.models.Client;
import org.team1.repositories.ClientRepository;
import java.security.Principal;

@RestController
public class LoggedInClientController {

    private final ClientRepository clientRepository;

    @Autowired
    public LoggedInClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/client")
    public Client getLoggedInClient(Principal principal) {
        if (principal == null) {
            throw new NoLoggedInClientException();
        } else {
            Client loggedInUser = clientRepository.findByUsername(principal.getName());
            return loggedInUser;
        }
    }
}
