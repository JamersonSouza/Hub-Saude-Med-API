package tech.jamersondev.medapi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.jamersondev.medapi.domain.Patient;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
}
