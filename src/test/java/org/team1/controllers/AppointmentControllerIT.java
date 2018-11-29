package org.team1.controllers;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.team1.InsApp;
import org.team1.models.Appointment;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InsApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppointmentControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;



    @Test
//    @WithMockUser(username = "client", password = "client")   //todo: HOW ???
    public void testGetClientById() {
        long appointmentId = 2l;
        ResponseEntity<Appointment> response = restTemplate.getForEntity(createURLWithPort("/appointment/{id}"), Appointment.class, appointmentId);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getId()).isEqualTo(2);
        assertThat(response.getBody().getClient().getAmka()).isEqualTo(123456780);
        assertThat(response.getBody().getDoctor().getLastName()).isEqualTo("DoctorDL");
        assertThat(response.getBody().getDoctor().getSpecialty().getName()).isEqualTo("Cardiologist");
    }


    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }










}
