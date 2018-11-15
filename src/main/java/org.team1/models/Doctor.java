package org.team1.models;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "doctorEntity")
@Table(name = "doctor")
public class Doctor implements Serializable {

    private int amka;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int phone;
    private String email;
    private Specialty specialty;
    private Appointment appointment;

    public Doctor(){}

    public Doctor(int amka,String firstName, String lastName, String username, String password, int phone,
                  String email, Specialty specialty){

        this.amka = amka;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.specialty = specialty;
    }

    @Id
    public int getAmka() {
        return amka;
    }
    public void setAmka(int amka) {
        this.amka = amka;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name= "phone")
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToOne
    @JoinColumn(name = "id")
    public Specialty getSpecialty(){ return specialty;}
    public void setSpecialty(Specialty specialty) { this.specialty = specialty; }

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    public Appointment getAppointment(){ return appointment; }
    public void setAppointment(Appointment appointment){ this.appointment = appointment; }


    @Override
    public String toString(){
        return "Doctor{" + "amka=" + amka + ",First Name=" + firstName + ",Last Name=" + lastName + ",username=" + username +
                ",phone=" + phone + ",email=" + email + ",specialty=" + specialty + '\'' + '}';
    }
}

