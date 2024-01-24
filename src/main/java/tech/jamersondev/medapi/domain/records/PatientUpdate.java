package tech.jamersondev.medapi.domain.records;

import java.util.UUID;

public record PatientUpdate(UUID patientIdentifier, String nome, String telefone, AddressObject addressObject) {
}
