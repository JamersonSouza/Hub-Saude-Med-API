package tech.jamersondev.medapi.domain;

import jakarta.persistence.*;
import tech.jamersondev.medapi.domain.records.PatientObject;
import tech.jamersondev.medapi.domain.records.PatientUpdate;

import java.util.Date;
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

    @Column(name = "isActive")
    private boolean isActive;
    private Date deletedDate;

    public Patient() {
    }

    public Patient(PatientObject patientObject) {
        this.isActive = true;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    public void deleteLogic() {
        this.isActive = false;
        this.deletedDate = new Date();
    }

    public void updateInformations(PatientUpdate patientUpdate) {
        this.nome = patientUpdate.nome() != null  ? patientUpdate.nome() : this.nome;
        this.telefone = patientUpdate.telefone() != null ? patientUpdate.telefone() : this.telefone;
        this.address = patientUpdate.addressObject() != null ? this.address.updateAddress(patientUpdate.addressObject()) : this.address;
    }
}
