package org.team1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.team1.models.Client;
import org.team1.models.Doctor;
import org.team1.repositories.ClientRepository;
import org.team1.repositories.DoctorRepository;

@Configuration
public class LoadDatabase {


    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ClientRepository bookRepository, DoctorRepository userRepository,
                                   PasswordEncoder passwordEncoder) {
        return args -> {
//            logger.info("Preloading " + bookRepository.save(new Book("The Grapes of Wrath", "0143125508")));
//            logger.info("Preloading " + bookRepository.save(new Book("Symposium", "0872200760")));
//            logger.info("Preloading " + bookRepository.save(new Book("Pride and Prejudice", "0486284735")));
//            logger.info("Preloading " + bookRepository.save(new Book("The Great Gatsby", "9780141182636")));

//            Doctor userGuest = new Doctor("Doctor", passwordEncoder.encode("userPassword"));
//            logger.info("Preloading " + userRepository.save(userGuest));
//            Client userGuest = new Client("Client", passwordEncoder.encode("userPassword"));
//            logger.info("Preloading " + userRepository.save(userGuest));

        };
    }
}
