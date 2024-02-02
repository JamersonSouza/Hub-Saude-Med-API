package tech.jamersondev.medapi.repositorys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.jamersondev.medapi.domain.Patient;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
    Page<Patient> findAllByIsActiveTrue(Pageable pageable);

    @Query(value = """
            select p.isActive from Patient AS p
            where p.patientIdentifier = :patientUUID
            """, nativeQuery = false)
    Boolean findIsActiveByUUID(UUID patientUUID);

    Patient findByIsActive(UUID patientIdentifier);
}
