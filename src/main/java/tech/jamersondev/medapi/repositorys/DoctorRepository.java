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

    @Query("""
            select d from Doctor d
            where
            d.isActive = true
            d.specialty = :specialty
            and
            d.doctorIdentifier not in (
            select h.doctor.doctorIdentifier from HubScheduling
            where
            h.dateScheduling = : dateScheduling
            )
            order by rand()
            limit 1
            """)
    Doctor selectDoctorRandomBySpecialtyAvaliableDate(SpecialtyEnum specialty, LocalDateTime dateScheduling);
}
