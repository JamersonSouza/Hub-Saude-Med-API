package tech.jamersondev.medapi.domain.records;

import tech.jamersondev.medapi.domain.Doctor;
import tech.jamersondev.medapi.domain.enums.SpecialtyEnum;

public record DoctorList(String nome, String email, String crm, SpecialtyEnum Specialty) {

    public DoctorList (Doctor doctor){
        this(doctor.getNome(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
