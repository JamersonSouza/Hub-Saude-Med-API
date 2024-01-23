package tech.jamersondev.medapi.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.jamersondev.medapi.domain.Patient;
import tech.jamersondev.medapi.domain.records.PatientList;
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

    public Page<PatientList> listPatients(Pageable pageable){
        return this.patientRepository.findAll(pageable).map(PatientList::new);
    }
}

