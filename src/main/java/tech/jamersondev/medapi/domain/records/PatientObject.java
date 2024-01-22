package tech.jamersondev.medapi.domain.records;

public record PatientObject(String nome, String email, String cpf, String telefone, AddressObject address) {
}
