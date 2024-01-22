package tech.jamersondev.medapi.domain;

import jakarta.persistence.*;
import tech.jamersondev.medapi.domain.records.AddressObject;
import tech.jamersondev.medapi.domain.records.PatientObject;

import java.util.UUID;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID patientIdentifier;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    @Embedded
    private Address address;

    public Patient() {
    }

    public Patient(PatientObject patientObject) {
        this.nome = patientObject.nome();
        this.email = patientObject.email();
        this.cpf = patientObject.cpf();
        this.telefone = patientObject.telefone();
        this.address = new Address(patientObject.address());
    }

    public UUID getPatientIdentifier() {
        return patientIdentifier;
    }

    public void setPatientIdentifier(UUID patientIdentifier) {
        this.patientIdentifier = patientIdentifier;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
