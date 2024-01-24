package tech.jamersondev.medapi.domain.records;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import tech.jamersondev.medapi.domain.Doctor;
import tech.jamersondev.medapi.domain.enums.SpecialtyEnum;

public record DoctorObject(
        @NotBlank(message = "{name.not.null.or.blank}")
        String nome,
        @NotBlank(message = "{mail.not.null.or.blank}")
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotBlank
        String telefone,
        @NotNull
        SpecialtyEnum specialty,
        @NotNull
        @Valid
        AddressObject address) {

        public DoctorObject (Doctor doctor){
                this(doctor.getNome(), doctor.getEmail(), doctor.getCrm(), doctor.getTelefone(), doctor.getSpecialty(),
                        new AddressObject(doctor.getAddress()));
        }
}
