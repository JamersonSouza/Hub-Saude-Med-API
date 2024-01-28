package tech.jamersondev.medapi.domain.records;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import tech.jamersondev.medapi.domain.enums.SpecialtyEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public record SchedulingDetails(UUID doctorIdentifier,
                                @NotNull UUID patientIdentifier,
                                @NotNull @Future LocalDateTime dateScheduling,
                                SpecialtyEnum specialtyEnum) {
}
