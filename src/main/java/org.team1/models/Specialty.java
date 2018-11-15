package org.team1.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "specialtyEntity")
@Table(name = "specialty")
public class Specialty implements Serializable {

    private Long id;
    private String name;
    private Doctor doctor;

    public Specialty(){}

    public Specialty(String name){ this.name = name; }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @Column(name = "name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @OneToMany(mappedBy = "specialty", cascade = CascadeType.ALL)
    public Doctor getDoctor(){
        return doctor;
    }

    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "id=" + id +
                ", specialty='" + name + '\'' +
                '}';
    }
}
