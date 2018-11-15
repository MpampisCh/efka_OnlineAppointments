package org.team1.models;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Appointment {

    private Long id;
    private Long clientAmka;
    private Long doctorAmka;
    private Date dateTime;
    private String description;
    private String notes;

    public Appointment(){}

    public Appointment(Long clientAmka, Long doctorAmka, Date dateTime, String description, String notes) {
        this.clientAmka = clientAmka;
        this.doctorAmka = doctorAmka;
        this.dateTime = dateTime;
        this.description = description;
        this.notes = notes;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getClientAmka() { return clientAmka; }
    public void setClientAmka(Long clientAmka) { this.clientAmka = clientAmka; }

    public Long getDoctorAmka() { return doctorAmka; }
    public void setDoctorAmka(Long doctorAmka) { this.doctorAmka = doctorAmka; }

    public Date getDateTime() { return dateTime; }
    public void setDateTime(Date dateTime) { this.dateTime = dateTime; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", clientAmka='" + clientAmka + '\'' +
                ", doctorAmka='" + doctorAmka + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", description='" + description + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}