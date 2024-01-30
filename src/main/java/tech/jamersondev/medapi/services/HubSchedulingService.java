package tech.jamersondev.medapi.services;

import org.springframework.stereotype.Service;
import tech.jamersondev.medapi.domain.Doctor;
import tech.jamersondev.medapi.domain.HubScheduling;
import tech.jamersondev.medapi.domain.Patient;
import tech.jamersondev.medapi.domain.records.SchedulingDetails;
import tech.jamersondev.medapi.exceptions.NotExistException;
import tech.jamersondev.medapi.repositorys.DoctorRepository;
import tech.jamersondev.medapi.repositorys.HubSchedulingRepository;
import tech.jamersondev.medapi.repositorys.PatientRepository;
import tech.jamersondev.medapi.validations.ValidateSchedulingConsult;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HubSchedulingService {


    private final HubSchedulingRepository schedulingRepository;

    private final PatientRepository patientRepository;

    private final DoctorRepository doctorRepository;

    private List<ValidateSchedulingConsult> validations;

    public HubSchedulingService(HubSchedulingRepository schedulingRepository, PatientRepository patientRepository, DoctorRepository doctorRepository, List<ValidateSchedulingConsult> validations) {
        this.schedulingRepository = schedulingRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.validations = validations;
    }

    public HubScheduling schedule(SchedulingDetails details) {
        if(details.patientIdentifier() == null || details.doctorIdentifier() == null){
            throw new NotExistException("Identifier doctor or patient is null");
        }
        validations.forEach(v->v.validation(details));
        Patient patient = this.patientRepository.findById(details.patientIdentifier()).orElseThrow( () -> new NotExistException("Patient not found: " + details.patientIdentifier()));
        Doctor doctor = this.doctorRepository.findById(details.doctorIdentifier()).orElseThrow(() -> new NotExistException("Doctor not found: " + details.doctorIdentifier()));
        return new HubScheduling(UUID.randomUUID(), doctor, patient, details.dateScheduling());
    }

    private Doctor findDoctorRandomIsIdentifierNull(SchedulingDetails details){
        if(details.doctorIdentifier() != null){
            return this.doctorRepository.getReferenceById(details.doctorIdentifier());
        }
        if(details.specialtyEnum() == null){
            throw new NotExistException("Specialty is mandatory");
        }
        return this.doctorRepository.selectDoctorRandomBySpecialtyAvaliableDate(details.specialtyEnum(), details.dateScheduling());
    }
}
