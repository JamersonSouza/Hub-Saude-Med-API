package tech.jamersondev.medapi.validations;

import tech.jamersondev.medapi.domain.records.SchedulingDetails;
import tech.jamersondev.medapi.exceptions.ValidationException;
import tech.jamersondev.medapi.repositorys.DoctorRepository;
import tech.jamersondev.medapi.repositorys.PatientRepository;

public class HubValidationPatientIsActive implements ValidateSchedulingConsult{

    private final PatientRepository patientRepository;

    public HubValidationPatientIsActive(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void validation(SchedulingDetails schedulingDetails){//validatePatientIsActive
        if(schedulingDetails.patientIdentifier() == null){
            return;
        }
        Boolean isActiveByUUID = this.patientRepository.findIsActiveByUUID(schedulingDetails.doctorIdentifier());
        if(!isActiveByUUID){
            throw new ValidationException("Consulta não pode ser agendada, paciente excluído");
        }
    }
}