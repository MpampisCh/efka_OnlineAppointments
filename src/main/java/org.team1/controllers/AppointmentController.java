package org.team1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.team1.exceptions.AppointmentNotFoundException;
import org.team1.models.Appointment;
import org.team1.models.Client;
import org.team1.repositories.AppointmentRepository;
import org.team1.services.AppointmentService;
import org.team1.services.ClientService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Set;

@RestController
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;
    private AppointmentService appointmentService;
    private ClientService clientService;

    @Autowired
    public AppointmentController(AppointmentRepository appointmentRepository, AppointmentService appointmentService, ClientService clientService) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentService = appointmentService;
        this.clientService =clientService;
    }

    @GetMapping("/appointments")
    public List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }

    @GetMapping("/appointment/{id}")
    public Appointment getAppointment(@PathVariable Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException(id));
    }


    @PostMapping("/newAppointment")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment createAppointment(@Valid @RequestBody Appointment appointment, Principal principal){
        Client client = clientService.findByUserName(principal.getName());
        return appointmentService.createAppointment(appointment,client);
    }

    @GetMapping("/appointments/{client_id}")
    public Set<Appointment> getAppointmentsByClient(Principal principal) {
        return appointmentService.getAppointmentsByClientUsername(principal.getName());
    }



    @PutMapping("/appointment/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment updateAppointment) {
        return appointmentRepository.findById(id)
                .map(appointment -> {
                    appointment.setDateTime(updateAppointment.getDateTime());
                    appointment.setDescription(updateAppointment.getDescription());
                    appointment.setNotes(updateAppointment.getNotes());
                    return appointmentRepository.save(appointment);
                })
                .orElseThrow(() -> new AppointmentNotFoundException(id));
    }

    @DeleteMapping("appointment/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteAppointment(@PathVariable Long id) {
        getAppointment(id);
        appointmentRepository.deleteById(id);
    }
}
