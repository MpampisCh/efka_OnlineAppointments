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
//            logger.info("Preloading " + clientRepository.save(new Client(123456789,"clientFirst","ClientLast",
//                    "client", passwordEncoder.encode("client"),
//                    1234567890, "client@")));
//
//            Specialty specialty1 = new Specialty("Παθολόγος");
//            Specialty specialty2 = new Specialty("Καρδιολόγος");
//            Specialty specialty3 = new Specialty("Γυναικολόγος");
//            Specialty specialty4 = new Specialty("Πνευμονολόγος");
//            Specialty specialty5 = new Specialty("Ωτορινολαρυγγολόγος");
//
//
//            logger.info("Preloading" + specialtyRepository.save(specialty1));
//            logger.info("Preloading" + specialtyRepository.save(specialty2));
//            logger.info("Preloading" + specialtyRepository.save(specialty3));
//            logger.info("Preloading" + specialtyRepository.save(specialty4));
//            logger.info("Preloading" + specialtyRepository.save(specialty5));
//
//            Doctor doctor1 = new Doctor(111111111,"DoctorAF","DoctorAL",
//                    "doctorA", passwordEncoder.encode("doctorA"),
//                    1234567880, "doctor1@mail.com", specialty1);
//            logger.info("Preloading " + doctorRepository.save(doctor1));
//
//
//            Doctor doctor2 = new Doctor(22222222,"DoctorBF","DoctorBL",
//                    "doctorB", passwordEncoder.encode("doctorB"),
//                    1234567881, "doctor2@mail.com", specialty1);
//            logger.info("Preloading " + doctorRepository.save(doctor2));
//
//            Doctor doctor3 = new Doctor(333333333,"DoctorCF","DoctorCL",
//                    "doctorC", passwordEncoder.encode("doctorC"),
//                    1234567882, "doctor3@mail.com", specialty1);
//            logger.info("Preloading " + doctorRepository.save(doctor3));
//
//            Doctor doctor4 = new Doctor(444444444,"DoctorDF","DoctorDL",
//                    "doctorD", passwordEncoder.encode("doctorD"),
//                    1234567883, "doctor4@mail.com", specialty2);
//            logger.info("Preloading " + doctorRepository.save(doctor4));
//
//            Doctor doctor5 = new Doctor(555555555,"DoctorEF","DoctorEL",
//                    "doctorE", passwordEncoder.encode("doctorE"),
//                    1234567880, "doctor5@mail.com", specialty2);
//            logger.info("Preloading " + doctorRepository.save(doctor5));
//
//            Doctor doctor6 = new Doctor(666666666,"DoctorFF","DoctorFL",
//                    "doctorF", passwordEncoder.encode("doctorF"),
//                    1234567884, "doctor6@mail.com", specialty3);
//            logger.info("Preloading " + doctorRepository.save(doctor6));
//
//            Doctor doctor7 = new Doctor(777777777,"DoctorGF","DoctorGL",
//                    "doctorG", passwordEncoder.encode("doctorG"),
//                    1234567885, "doctor7@mail.com", specialty4);
//            logger.info("Preloading " + doctorRepository.save(doctor7));
//
//            Doctor doctor8 = new Doctor(888888888,"DoctorHF","DoctorHL",
//                    "doctorH", passwordEncoder.encode("doctorH"),
//                    1234567886, "doctor8@mail.com", specialty5);
//            logger.info("Preloading " + doctorRepository.save(doctor8));

        };
    }

}