package tech.jamersondev.medapi.repositorys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.jamersondev.medapi.domain.Patient;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
    Page<Patient> findAllByIsActiveTrue(Pageable pageable);
}
