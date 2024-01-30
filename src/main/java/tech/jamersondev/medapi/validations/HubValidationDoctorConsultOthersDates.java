package tech.jamersondev.medapi.validations;

import tech.jamersondev.medapi.domain.records.SchedulingDetails;
import tech.jamersondev.medapi.exceptions.ValidationException;
import tech.jamersondev.medapi.repositorys.HubSchedulingRepository;

public class HubValidationDoctorConsultOthersDates implements ValidateSchedulingConsult{

    private final HubSchedulingRepository hubSchedulingRepository;

    public HubValidationDoctorConsultOthersDates(HubSchedulingRepository hubSchedulingRepository) {
        this.hubSchedulingRepository = hubSchedulingRepository;
    }

    public void validation(SchedulingDetails schedulingDetails) {//validatedConsultOtherDate
        boolean consultOtherDateAndSameTime = this.hubSchedulingRepository.existsByDoctorIdAndDate(schedulingDetails.doctorIdentifier(), schedulingDetails.dateScheduling());
        if(consultOtherDateAndSameTime){
            throw new ValidationException("Médico já possui consulta agendada nesse mesmo horário");
        }
    }
}
