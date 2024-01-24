package tech.jamersondev.medapi.domain.records;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DoctorUpdate(UUID doctorIdentifier, String nome, String telefone, AddressObject address) {
}
