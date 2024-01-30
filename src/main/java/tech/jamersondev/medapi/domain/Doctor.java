package tech.jamersondev.medapi.domain;

import jakarta.persistence.*;
import tech.jamersondev.medapi.domain.enums.SpecialtyEnum;
import tech.jamersondev.medapi.domain.records.DoctorObject;
import tech.jamersondev.medapi.domain.records.DoctorUpdate;

import java.util.Date;
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
    private String telefone;
    @Enumerated(EnumType.STRING)
    private SpecialtyEnum specialty;
    @Embedded
    private Address address;

    private boolean isActive;

    private Date deletedDate;

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

    public Doctor(DoctorObject doctorObj) {
        this.isActive = true;
        this.nome = doctorObj.nome();
        this.email = doctorObj.email();
        this.crm = doctorObj.crm();
        this.specialty = doctorObj.specialty();
        this.telefone = doctorObj.telefone();
        this.address = new Address(doctorObj.address());
    }

    public Doctor(String name){
        this.nome = name;
    }

    public void updateInformations(DoctorUpdate doctorUpdate) {
        this.nome = doctorUpdate.nome() != null  ? doctorUpdate.nome() : this.nome;
        this.telefone = doctorUpdate.telefone() != null ? doctorUpdate.telefone() : this.telefone;
        this.address = doctorUpdate.address() != null ? this.address.updateAddress(doctorUpdate.address()) : this.address;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
}
