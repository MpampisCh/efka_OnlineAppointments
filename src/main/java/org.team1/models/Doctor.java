package org.team1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "doctorEntity")
@Table(name = "doctor")
public class Doctor implements Serializable {

    private int amka;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String passwordConfirm;
    private int phone;
    private String email;
    private Specialty specialty;
    private Set<Appointment> appointments;

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
    @Column(unique = true, nullable = false)
    public int getAmka() {
        return amka;
    }
    public void setAmka(int amka) {
        this.amka = amka;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "lastName", nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "username", unique = true, nullable = false)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false)
    @JsonIgnore
    public String getPassword() {
        return password;
    }
    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() { return passwordConfirm; }
    public void setPasswordConfirm(String passwordConfirm) { this.passwordConfirm = passwordConfirm; }

    @Column(name= "phone", nullable = false)
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    public Specialty getSpecialty(){ return specialty;}
    public void setSpecialty(Specialty specialty) { this.specialty = specialty; }

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    public Set<Appointment> getAppointments(){ return appointments; }
    public void setAppointments(Set<Appointment> appointments){ this.appointments = appointments; }

    @Override
    public String toString(){
        return "Doctor{" + "amka=" + amka + ",First Name=" + firstName + ",Last Name=" + lastName + ",username=" + username +
                ",phone=" + phone + ",email=" + email + ",specialty=" + specialty + '\'' + '}';
    }
}

