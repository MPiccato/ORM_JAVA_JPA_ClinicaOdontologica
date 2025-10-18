package com.dh.ClinicaOdontologicaII.entities;


import jakarta.persistence.*;

//Anotaciones
@Entity
@Table(name = "Dentists")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dentist_id")
    private Integer id;

    @Column(name = "registration", nullable = false)
    private Integer registration;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "latName", nullable = false)
    private String lastName;

    //Constructor por defecto vacío
    public Dentist() {
    }

    // Getters y Setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRegistration() {
        return registration;
    }

    public void setRegistration(Integer registration) {
        this.registration = registration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
