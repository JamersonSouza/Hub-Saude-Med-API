package tech.jamersondev.medapi.domain.records;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import tech.jamersondev.medapi.domain.HubScheduling;

import java.time.LocalDateTime;
import java.util.UUID;

public record SchedulingDetailsResponse(UUID schedulingIdentifier, UUID doctorIdentifier,
                                       UUID patientIdentifier,
                                      LocalDateTime dateScheduling) {

    public SchedulingDetailsResponse (HubScheduling scheduling){
        this(scheduling.getHubSchedulingIdentifier(), scheduling.getDoctor().getDoctorIdentifier(),
                scheduling.getPatient().getPatientIdentifier(), scheduling.getDateScheduling());
    }
}
