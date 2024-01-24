package tech.jamersondev.medapi.domain.records;

import tech.jamersondev.medapi.domain.Patient;

import java.util.UUID;

public record PatientList(UUID patientIdentifier, boolean isActive, String nome, String email, String cpf) {
    public PatientList (Patient patient){
        this(patient.getPatientIdentifier(), patient.isActive(),patient.getNome(), patient.getEmail(), patient.getCpf());
    }
}
