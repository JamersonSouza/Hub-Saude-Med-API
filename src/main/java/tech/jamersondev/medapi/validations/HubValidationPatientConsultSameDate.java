package tech.jamersondev.medapi.validations;

import tech.jamersondev.medapi.domain.records.SchedulingDetails;
import tech.jamersondev.medapi.exceptions.ValidationException;
import tech.jamersondev.medapi.repositorys.HubSchedulingRepository;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class HubValidationPatientConsultSameDate implements ValidateSchedulingConsult{

    private HubSchedulingRepository hubSchedulingRepository;
    public void validation(SchedulingDetails schedulingDetails){//validatePatientConsultSameTime
        LocalDateTime firstHour = schedulingDetails.dateScheduling().withHour(7);
        LocalDateTime lastHour = schedulingDetails.dateScheduling().withHour(18);
        boolean existsByPatientIdAndDataBetween = this.hubSchedulingRepository.existsByPatientPatientIdentifierAndDateSchedulingBetween(schedulingDetails.patientIdentifier(), firstHour, lastHour);
        if(existsByPatientIdAndDataBetween){
            throw new ValidationException("Paciente já possui uma consulta agendada neste dia");
        }
    }
}
