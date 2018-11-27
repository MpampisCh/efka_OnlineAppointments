package org.team1.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.team1.models.Appointment;
import org.team1.repositories.AppointmentRepository;

import java.util.Set;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment createAppointment(Appointment appointment){

        Appointment newAppointment = new Appointment();
        newAppointment.setClient(appointment.getClient());
        newAppointment.setDoctor(appointment.getDoctor());
        newAppointment.setDateTime(appointment.getDateTime());
        newAppointment.setDescription(appointment.getDescription());
        newAppointment.setNotes(appointment.getNotes());

        appointmentRepository.save(newAppointment);
        return newAppointment;
    }

    public Set<Appointment> getAppointmentsByClientAmka(Long id){
        return appointmentRepository.findAllByClient(id);
    }
}
