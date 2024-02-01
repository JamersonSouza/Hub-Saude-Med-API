package tech.jamersondev.medapi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.jamersondev.medapi.domain.HubScheduling;

import java.time.LocalDateTime;
import java.util.UUID;

public interface HubSchedulingRepository extends JpaRepository<HubScheduling, UUID> {
    boolean existsByDoctorDoctorIdentifierAndDateScheduling(UUID uuid, LocalDateTime localDateTime);

    boolean existsByPatientPatientIdentifierAndDateSchedulingBetween(UUID uuid, LocalDateTime firstHour, LocalDateTime lastHour);
}
