package org.team1.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.team1.exceptions.ClientNotFoundException;
import org.team1.models.Client;
import org.team1.repositories.ClientRepository;
import org.team1.security.MyClientDetails;

@Service
public class MyClientDetailsService implements UserDetailsService {

    private final ClientRepository clientRepository;

    @Autowired
    public MyClientDetailsService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws ClientNotFoundException {
        Client client = clientRepository.findByUsername(username);
        if (client == null) {
            throw new ClientNotFoundException(client.getAmka());
        }
        return new MyClientDetails(client);
    }

}
