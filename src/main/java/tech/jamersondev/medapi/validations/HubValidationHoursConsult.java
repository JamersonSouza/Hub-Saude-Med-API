package tech.jamersondev.medapi.validations;

import org.springframework.stereotype.Component;
import tech.jamersondev.medapi.domain.records.SchedulingDetails;
import tech.jamersondev.medapi.exceptions.ValidationException;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class HubValidationHoursConsult implements ValidateSchedulingConsult{
    public void validation(SchedulingDetails schedulingDetails){//validatedHours

        LocalDateTime dateScheduling = schedulingDetails.dateScheduling();
        LocalDateTime dateNow = LocalDateTime.now();

        long differentMinutesBetweenScheduling = Duration.between(dateNow, dateScheduling).toMinutes();
        if(differentMinutesBetweenScheduling < 30){
            throw new ValidationException("Consulta deve ser agendada com 30 minutos de antecedência");
        }


    }
}
