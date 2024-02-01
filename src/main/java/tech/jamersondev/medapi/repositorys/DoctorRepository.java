package tech.jamersondev.medapi.repositorys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.jamersondev.medapi.domain.Doctor;
import tech.jamersondev.medapi.domain.enums.SpecialtyEnum;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
    Page<Doctor> findAllByIsActiveTrue(Pageable pageable);

    @Query(value = """
             SELECT d FROM Doctor d
              WHERE
              d.specialty = :specialty
              AND
              d.doctorIdentifier NOT IN (
               SELECT h.doctor.doctorIdentifier FROM HubScheduling h
               WHERE
               h.dateScheduling = :dateScheduling
               )
              ORDER BY FUNCTION('RAND')
              LIMIT 1
            """, nativeQuery = false)
    Doctor selectDoctorRandomBySpecialtyAvaliableDate(SpecialtyEnum specialty, LocalDateTime dateScheduling);

    @Query(value = """
            select d from Doctor AS d
            where d.doctorIdentifier = :doctorUUID
            """, nativeQuery = false)
    Boolean findIsActiveByUUID(UUID doctorUUID);

}
