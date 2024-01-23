package tech.jamersondev.medapi.repositorys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.jamersondev.medapi.domain.Doctor;

import java.util.Optional;
import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
    Page<Doctor> findAllByIsActiveTrue(Pageable pageable);
}
