package org.team1.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;



public class Doctor {

    private int amka;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int phone;
    private String email;
    private Specialty specialty;

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
    @GeneratedValue

    public int getAmka() {
        return amka;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setAmka(int amka) {
        this.amka = amka;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString(){
        return "Client{" + "amka=" + amka + ",First Name=" + firstName + ",Last Name=" + lastName + ",username=" + username +
                ",phone=" + phone + ",email=" + email + ",specialty=" + specialty + '\'' + '}';
    }
}

