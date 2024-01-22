package tech.jamersondev.medapi.services;

import org.springframework.stereotype.Service;
import tech.jamersondev.medapi.domain.Patient;
import tech.jamersondev.medapi.domain.records.PatientObject;
import tech.jamersondev.medapi.repositorys.PatientRepository;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient savePatient(PatientObject patientObject){
        return this.patientRepository.save(new Patient(patientObject));
    }
}
