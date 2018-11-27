package org.team1.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.print.Doc;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "appointmentEntity")
@Table(name = "appointment")
public class Appointment implements Serializable{

    private Long id;
    private Client client;
    private Doctor doctor;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm")
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @ManyToOne
    @JoinColumn(name = "client_id")
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    @Column(name = "datetime")
    @Nullable
    public Date getDateTime() { return dateTime; }
    public void setDateTime(Date dateTime) { this.dateTime = dateTime; }

    @Column(name = "description")
    @Nullable
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