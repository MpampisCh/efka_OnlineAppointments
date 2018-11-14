package org.team1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.team1.models.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
