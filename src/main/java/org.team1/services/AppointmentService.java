package org.team1.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.team1.models.Appointment;
import org.team1.models.Client;
import org.team1.repositories.AppointmentRepository;
import org.team1.repositories.ClientRepository;
import org.team1.repositories.DoctorRepository;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorService doctorService;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository,DoctorService doctorService) {
        this.appointmentRepository = appointmentRepository;
        this.doctorService = doctorService;
    }

    public Appointment createAppointment(Appointment appointment, Client client){

        Appointment newAppointment = new Appointment();

        newAppointment.setClient(client);
        newAppointment.setDoctor(doctorService.findDoctorByAmka(appointment.getDoctor().getAmka()));
        newAppointment.setDateTime(appointment.getDateTime());
        newAppointment.setDescription(appointment.getDescription());
        newAppointment.setNotes(appointment.getNotes());

        appointmentRepository.save(newAppointment);
        return newAppointment;
    }

    public Set<Appointment> getAppointmentsByClientUsername(String username){
        return appointmentRepository.findAppointmentsByClientUsernameEquals(username);
    }
}
