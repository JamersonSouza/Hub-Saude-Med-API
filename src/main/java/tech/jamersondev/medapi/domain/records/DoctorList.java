package tech.jamersondev.medapi.domain.records;

import tech.jamersondev.medapi.domain.Doctor;
import tech.jamersondev.medapi.domain.enums.SpecialtyEnum;

import java.util.UUID;

public record DoctorList(UUID doctorIdentifier, boolean isActive, String nome, String email, String crm, SpecialtyEnum Specialty) {

    public DoctorList (Doctor doctor){
        this(doctor.getDoctorIdentifier(), doctor.isActive(), doctor.getNome(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
