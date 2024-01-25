package tech.jamersondev.medapi.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.jamersondev.medapi.domain.Patient;
import tech.jamersondev.medapi.domain.records.PatientList;
import tech.jamersondev.medapi.domain.records.PatientObject;
import tech.jamersondev.medapi.domain.records.PatientUpdate;
import tech.jamersondev.medapi.repositorys.PatientRepository;

import java.util.UUID;

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
        return this.patientRepository.findAllByIsActiveTrue(pageable).map(PatientList::new);
    }

    public void deleteLogic(UUID id) {
        Patient patient = this.patientRepository.getReferenceById(id);
        patient.deleteLogic();
    }

    public Patient updatePatient(PatientUpdate patientUpdate, UUID patientUUID) {
        Patient patient = this.patientRepository.getReferenceById(patientUUID);
        patient.updateInformations(patientUpdate);
        return patient;
    }

    public Patient findPatientByUUID(UUID patientUUID) {
        Patient patient = this.patientRepository.getReferenceById(patientUUID);
        return patient;
    }
}

