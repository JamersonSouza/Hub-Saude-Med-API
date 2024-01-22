package tech.jamersondev.medapi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.jamersondev.medapi.domain.Doctor;

import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
}
