package org.team1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.team1.models.Doctor;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByUsername(String username);

    @Query("select doc from Doctor doc inner join Specialty sp where doc.id = sp.id")
    List<Doctor> findBySpecialty(Long id);
}
