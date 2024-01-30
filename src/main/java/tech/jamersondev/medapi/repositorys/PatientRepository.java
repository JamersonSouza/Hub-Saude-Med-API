package tech.jamersondev.medapi.repositorys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.jamersondev.medapi.domain.Patient;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
    Page<Patient> findAllByIsActiveTrue(Pageable pageable);

    @Query("""
            select d.isActive from Patient
            where d.patientIdentifier = :patientUUID
            """)
    Boolean findIsActiveByUUID(UUID patientUUID);
}
