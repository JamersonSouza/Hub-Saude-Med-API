package tech.jamersondev.medapi.services;

import org.springframework.stereotype.Service;
import tech.jamersondev.medapi.domain.Doctor;
import tech.jamersondev.medapi.domain.records.DoctorObject;
import tech.jamersondev.medapi.repositorys.DoctorRepository;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor insertDoctor(DoctorObject doctorObj){
        return this.doctorRepository.save(new Doctor(doctorObj));
    }
}
