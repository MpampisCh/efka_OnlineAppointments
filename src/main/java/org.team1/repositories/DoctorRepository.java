package org.team1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.team1.models.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
