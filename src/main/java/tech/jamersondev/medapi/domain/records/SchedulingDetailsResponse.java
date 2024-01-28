package tech.jamersondev.medapi.domain.records;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record SchedulingDetailsResponse(UUID schedulingIdentifier, UUID doctorIdentifier,
                                       UUID patientIdentifier,
                                      LocalDateTime dateScheduling) {
}
