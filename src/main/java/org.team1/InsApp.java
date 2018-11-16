package org.team1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.team1.repositories.AppointmentRepository;
//import org.team1.repositories.ClientRepository;
import org.team1.repositories.DoctorRepository;
import org.team1.repositories.SpecialtyRepository;


@SpringBootApplication
public class InsApp implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(InsApp.class);

    @Autowired
    private AppointmentRepository appointmentRepository;
//    private ClientRepository clientRepository;
    private DoctorRepository doctorRepository;
    private SpecialtyRepository specialtyRepository;

    public static void main(String[] args )
    {
        SpringApplication.run(InsApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
