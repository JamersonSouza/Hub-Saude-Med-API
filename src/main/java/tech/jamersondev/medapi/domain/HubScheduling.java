package tech.jamersondev.medapi.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Scheduling")
public class HubScheduling {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID hubSchedulingIdentifier;

    @ManyToOne
    @JoinColumn(name = "doctor_identifier")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_identifier")
    private Patient patient;

    private LocalDateTime dateScheduling;

    public HubScheduling() {
    }

    public HubScheduling(UUID hubSchedulingIdentifier, Doctor doctor, Patient patient, LocalDateTime dateScheduling) {
        this.hubSchedulingIdentifier = hubSchedulingIdentifier;
        this.doctor = doctor;
        this.patient = patient;
        this.dateScheduling = dateScheduling;
    }

    public UUID getHubSchedulingIdentifier() {
        return hubSchedulingIdentifier;
    }

    public void setHubSchedulingIdentifier(UUID hubSchedulingIdentifier) {
        this.hubSchedulingIdentifier = hubSchedulingIdentifier;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getDateScheduling() {
        return dateScheduling;
    }

    public void setDateScheduling(LocalDateTime dateScheduling) {
        this.dateScheduling = dateScheduling;
    }
}
