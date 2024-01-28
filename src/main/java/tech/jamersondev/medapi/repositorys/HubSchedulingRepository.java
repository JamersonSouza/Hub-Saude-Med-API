package tech.jamersondev.medapi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.jamersondev.medapi.domain.HubScheduling;

import java.util.UUID;

public interface HubSchedulingRepository extends JpaRepository<HubScheduling, UUID> {
}
