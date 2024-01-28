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

}
