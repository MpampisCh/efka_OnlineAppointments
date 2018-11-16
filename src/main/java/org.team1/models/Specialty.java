package org.team1.models;

import javax.persistence.*;
import javax.print.Doc;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "specialtyEntity")
@Table(name = "specialty")
public class Specialty implements Serializable {

    private Long id;
    private String name;
    private Set<Doctor> doctors;

    public Specialty(){}

    public Specialty(String name){
        this.name = name;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @Column(name = "name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @OneToMany(mappedBy = "specialty", cascade = CascadeType.ALL)
    public Set<Doctor> getDoctors(){ return doctors; }

    public void setDoctors(Set<Doctor> doctors){
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "id=" + id +
                ", specialty='" + name + '\'' +
                '}';
    }
}
