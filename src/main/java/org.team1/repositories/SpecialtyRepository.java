package org.team1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.team1.models.Specialty;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long>{


//    Specialty findById(Long id);
    Specialty findSpecialtiesById(Long id);

    Specialty findByName(String name);

    Specialty deleteByName(String name);
}
