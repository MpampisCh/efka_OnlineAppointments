package org.team1.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;



public class Doctor {

    private int amka;
    private String firstName;
    private String lastName;
    private String username;
    private Character password;
    private int phone;
    private Character email;
    private Specialty specialty;

    public Doctor(){}

    public Doctor(int amka,String firstName, String lastName, String username, Character password, int phone,
                  Character email, Specialty specialty){

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

    public Character getPassword() {
        return password;
    }

    public int getPhone() {
        return phone;
    }

    public Character getEmail() {
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

    public void setPassword(Character password) {
        this.password = password;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setEmail(Character email) {
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

