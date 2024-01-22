package tech.jamersondev.medapi.domain.records;

import tech.jamersondev.medapi.domain.enums.SpecialtyEnum;

public record DoctorObject(String nome, String email, String crm, SpecialtyEnum specialty, AddressObject address) {
}
