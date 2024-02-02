package tech.jamersondev.medapi.validations;

import org.springframework.stereotype.Component;
import tech.jamersondev.medapi.domain.records.SchedulingDetails;
import tech.jamersondev.medapi.exceptions.ValidationException;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Component
public class HubValidationSchedulingConsult implements ValidateSchedulingConsult{
    public void validation(SchedulingDetails schedulingDetails){//validatedScheduling
        LocalDateTime dateScheduling = schedulingDetails.dateScheduling();
        boolean isSunday = dateScheduling.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        boolean beforeOpenClinic = dateScheduling.getHour() < 7;
        boolean afterCloseClinic = dateScheduling.getHour() > 18;
        if(isSunday || beforeOpenClinic || afterCloseClinic){
            throw new ValidationException("Consulta fora do horário disponível");
        }
    }
}
