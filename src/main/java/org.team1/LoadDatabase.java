package org.team1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

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
//
//            Client client = new Client(123456780,"clientFirst","ClientLast",
//                    "client", passwordEncoder.encode("client"),
//                    1234567890, "client@gmail.com");
//
//            logger.info("Preloading " + clientRepository.save(client));
//
//            Specialty specialty1 = new Specialty("Pathologist");
//            Specialty specialty2 = new Specialty("Cardiologist");
//            Specialty specialty3 = new Specialty("Gynecologist");
//            Specialty specialty4 = new Specialty("Pneumologist");
//            Specialty specialty5 = new Specialty("Otolaryngologist");
//
//            logger.info("Preloading" + specialtyRepository.save(specialty1));
//            logger.info("Preloading" + specialtyRepository.save(specialty2));
//            logger.info("Preloading" + specialtyRepository.save(specialty3));
//            logger.info("Preloading" + specialtyRepository.save(specialty4));
//            logger.info("Preloading" + specialtyRepository.save(specialty5));
//
//            Doctor doctor1 = new Doctor(123456781,"DoctorAF","DoctorAL",
//                    "doctorA", passwordEncoder.encode("doctorA"),
//                    1234567880, "doctor1@gmail.com", specialty1);
//            Doctor doctor2 = new Doctor(123456782,"DoctorBF","DoctorBL",
//                    "doctorB", passwordEncoder.encode("doctorB"),
//                    1234567881, "doctor2@gmail.com", specialty1);
//            Doctor doctor3 = new Doctor(123456783,"DoctorCF","DoctorCL",
//                    "doctorC", passwordEncoder.encode("doctorC"),
//                    1234567882, "doctor3@gmail.com", specialty1);
//            Doctor doctor4 = new Doctor(123456784,"DoctorDF","DoctorDL",
//                    "doctorD", passwordEncoder.encode("doctorD"),
//                    1234567883, "doctor4@gmail.com", specialty2);
//            Doctor doctor5 = new Doctor(123456785,"DoctorEF","DoctorEL",
//                    "doctorE", passwordEncoder.encode("doctorE"),
//                    1234567880, "doctor5@gmail.com", specialty2);
//            Doctor doctor6 = new Doctor(123456786,"DoctorFF","DoctorFL",
//                    "doctorF", passwordEncoder.encode("doctorF"),
//                    1234567884, "doctor6@gmail.com", specialty3);
//            Doctor doctor7 = new Doctor(123456787,"DoctorGF","DoctorGL",
//                    "doctorG", passwordEncoder.encode("doctorG"),
//                    1234567885, "doctor7@gmail.com", specialty4);
//            Doctor doctor8 = new Doctor(123456788,"DoctorHF","DoctorHL",
//                    "doctorH", passwordEncoder.encode("doctorH"),
//                    1234567886, "doctor8@gmail.com", specialty5);
//
//            logger.info("Preloading " + doctorRepository.save(doctor1));
//            logger.info("Preloading " + doctorRepository.save(doctor2));
//            logger.info("Preloading " + doctorRepository.save(doctor3));
//            logger.info("Preloading " + doctorRepository.save(doctor4));
//            logger.info("Preloading " + doctorRepository.save(doctor5));
//            logger.info("Preloading " + doctorRepository.save(doctor6));
//            logger.info("Preloading " + doctorRepository.save(doctor7));
//            logger.info("Preloading " + doctorRepository.save(doctor8));
//
      };
    }

}