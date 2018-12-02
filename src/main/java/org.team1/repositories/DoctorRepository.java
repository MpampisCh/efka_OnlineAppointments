package org.team1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.team1.models.Doctor;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Doctor findByUsername(String username);

    Doctor findByAmka(long amka);

    List<Doctor> findDoctorsBySpecialtyNameEquals(String specName);


}
