package tech.jamersondev.medapi.domain;

import jakarta.persistence.*;
import tech.jamersondev.medapi.domain.enums.SpecialtyEnum;

import java.util.UUID;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID doctorIdentifier;
    private String nome;
    private String email;
    private String  crm;
    @Enumerated(EnumType.STRING)
    private SpecialtyEnum specialty;
    @Embedded
    private Address address;

    public Doctor() {
    }

    public Doctor(UUID doctorIdentifier, String nome, String email, String crm, SpecialtyEnum specialty, Address address) {
        this.doctorIdentifier = doctorIdentifier;
        this.nome = nome;
        this.email = email;
        this.crm = crm;
        this.specialty = specialty;
        this.address = address;
    }

    public UUID getDoctorIdentifier() {
        return doctorIdentifier;
    }

    public void setDoctorIdentifier(UUID doctorIdentifier) {
        this.doctorIdentifier = doctorIdentifier;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public SpecialtyEnum getSpecialty() {
        return specialty;
    }

    public void setSpecialty(SpecialtyEnum specialty) {
        this.specialty = specialty;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}