package tech.jamersondev.medapi.validations;

import tech.jamersondev.medapi.domain.Doctor;
import tech.jamersondev.medapi.domain.records.SchedulingDetails;
import tech.jamersondev.medapi.exceptions.ValidationException;
import tech.jamersondev.medapi.repositorys.DoctorRepository;

import java.time.Duration;
import java.time.LocalDateTime;

public class HubValidationDoctorIsActive implements ValidateSchedulingConsult{

    private final DoctorRepository doctorRepository;

    public HubValidationDoctorIsActive(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void validation(SchedulingDetails schedulingDetails){//validateDoctorIsActive
        if(schedulingDetails.doctorIdentifier() == null){
            return;
        }
        Boolean isActiveByUUID = this.doctorRepository.findIsActiveByUUID(schedulingDetails.doctorIdentifier());
        if(!isActiveByUUID){
            throw new ValidationException("Consulta não pode ser agendada");
        }
    }
}
