package org.team1.models;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.print.Doc;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "appointmentEntity")
@Table(name = "appointment")
public class Appointment implements Serializable{

    private Long id;
//    private Long clientAmka;
    private Client client;
//    private Long doctorAmka;
    private Doctor doctor;
    private Date dateTime;
    private String description;
    private String notes;

    public Appointment(){}

    public Appointment(Client client, Doctor doctor, Date dateTime, String description, String notes) {
        this.client = client;
        this.doctor = doctor;
        this.dateTime = dateTime;
        this.description = description;
        this.notes = notes;
    }

    @Id
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @ManyToOne
    @JoinColumn(name = "amka")
    public Client client() { return client; }
    public void setClientAmka(Client client) { this.client = client; }

    @ManyToOne
    @JoinColumn(name = "amka")
    public Doctor getDoctor() { return doctor; }
    public void setDoctorAmka(Doctor doctor) { this.doctor = doctor; }

    @Column(name = "datetime")
    public Date getDateTime() { return dateTime; }
    public void setDateTime(Date dateTime) { this.dateTime = dateTime; }

    @Column(name = "description")
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Column(name = "notes")
    @Nullable
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", client='" + client + '\'' +
                ", doctor='" + doctor + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", description='" + description + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}