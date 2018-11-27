package org.team1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.team1.models.Doctor;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByUsername(String username);

//    List<Doctor> findDoctorsBySpecialtyIdEquals(String name);

    List<Doctor> findDoctorsBySpecialtyNameEquals(String name);


}
