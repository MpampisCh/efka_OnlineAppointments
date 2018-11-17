package org.team1.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client implements Serializable {

    private int amka;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int phone;
    private String email;
    private Set<Appointment> appointments;

    public Client(){}

    public Client(int amka,String firstName, String lastName, String username, String password, int phone, String email){

        this.amka = amka;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    @Id
    public int getAmka() { return amka; }
    public void setAmka(int amka) { this.amka = amka; }

    @Column(name = "first_name")
    public String getFirstName() { return firstName; }
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
    public int getPhone() { return phone; }
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

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    public Set<Appointment> getAppointments(){ return appointments; }
    public void setAppointments(Set<Appointment> appointments){ this.appointments = appointments;  }

    @Override
    public String toString(){
        return "Client{" + "amka=" + amka + ",First Name=" + firstName + ",Last Name=" + lastName + ",username=" + username +
                ",phone=" + phone + ",email=" + email + '\'' + '}';
    }
}
