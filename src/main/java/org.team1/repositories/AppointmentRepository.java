package org.team1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.team1.models.Appointment;
import org.team1.models.Doctor;

import java.util.Set;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Appointment save(Appointment appointment);

    Set<Appointment> findAllByClient(Long id);

    Appointment findAllByDoctor(Doctor doctor);
}
