package org.team1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.team1.models.Client;
import org.team1.models.Doctor;
import org.team1.models.Specialty;
import org.team1.repositories.ClientRepository;
import org.team1.repositories.DoctorRepository;
import org.team1.repositories.SpecialtyRepository;

@Configuration
public class LoadDatabase {


    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ClientRepository clientRepository, DoctorRepository doctorRepository,
                                   SpecialtyRepository specialtyRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            logger.info("Preloading " + clientRepository.save(new Client(123456789,"clientFirst","ClientLast",
                    "client", passwordEncoder.encode("client"),
                    1234567890, "client@")));

            Specialty specialty = new Specialty("Pathologos");
            logger.info("Preloading" + specialtyRepository.save(specialty));

            Doctor doctor = new Doctor(1234567880,"doctorFirst","doctorLast",
                    "doctor", passwordEncoder.encode("doctor"),
                    1234567880, "doctor@mail.com", specialty);
            logger.info("Preloading " + doctorRepository.save(doctor));

        };
    }

}