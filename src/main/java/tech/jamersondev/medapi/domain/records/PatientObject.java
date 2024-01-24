package tech.jamersondev.medapi.domain.records;

import tech.jamersondev.medapi.domain.Patient;

public record PatientObject(String nome, String email, String cpf, String telefone, AddressObject address) {
    public PatientObject (Patient patient){
        this(patient.getNome(), patient.getEmail(), patient.getCpf(), patient.getTelefone(), new AddressObject(patient.getAddress()));
    }
}
