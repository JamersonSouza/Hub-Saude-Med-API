package tech.jamersondev.medapi.domain.records;

import tech.jamersondev.medapi.domain.Patient;

public record PatientList(String nome, String email, String cpf) {
    public PatientList (Patient patient){
        this(patient.getNome(), patient.getEmail(), patient.getCpf());
    }
}
