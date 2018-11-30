package org.team1.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.team1.exceptions.AppointmentNotFoundException;
import org.team1.models.Appointment;
import org.team1.models.Client;
import org.team1.repositories.AppointmentRepository;

import java.util.Date;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorService doctorService;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, DoctorService doctorService) {
        this.appointmentRepository = appointmentRepository;
        this.doctorService = doctorService;
    }

    public Appointment createAppointment(Appointment appointment, Client client) {

        Appointment newAppointment = new Appointment();

        newAppointment.setClient(client);
        newAppointment.setDoctor(doctorService.findDoctorByAmka(appointment.getDoctor().getAmka()));
        newAppointment.setDateTime(appointment.getDateTime());
        newAppointment.setDescription(appointment.getDescription());
        newAppointment.setNotes(appointment.getNotes());

        appointmentRepository.save(newAppointment);
        return newAppointment;
    }

    public List<Appointment> getAllAppointments() { return appointmentRepository.findAll(); }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException(id));
    }

    public List<Appointment> getAppointmentsByClientUsername(String username) {
        return appointmentRepository.findAppointmentsByClientUsernameEquals(username);
    }

    public List<Appointment> getAppointmentsByDoctorUsername(String username) {
        return appointmentRepository.findAppointmentsByDoctorUsernameEquals(username);
    }

    public List<Appointment> getAppointmentsBetweenDatesAndBySpecialty(Date startDate, Date endDate, String specName) {
        return appointmentRepository.findAppointmentsByDateTimeBetweenAndDoctor_Specialty_Name(startDate, endDate, specName);
    }

    public List<Appointment> getAppointmentsBetweenOrByDescription(Date startDate, Date endDate, String desc) {
        return appointmentRepository.findAppointmentsByDateTimeBetweenAndDescriptionContaining(startDate,endDate,desc);
    }



}
