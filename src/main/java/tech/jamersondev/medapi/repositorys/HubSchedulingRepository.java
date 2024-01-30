package tech.jamersondev.medapi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.jamersondev.medapi.domain.HubScheduling;

import java.time.LocalDateTime;
import java.util.UUID;

public interface HubSchedulingRepository extends JpaRepository<HubScheduling, UUID> {
    boolean existsByDoctorIdAndDate(UUID uuid, LocalDateTime localDateTime);

    boolean existsByPatientIdAndDataBetween(UUID uuid, LocalDateTime firstHour, LocalDateTime lastHour);
}
