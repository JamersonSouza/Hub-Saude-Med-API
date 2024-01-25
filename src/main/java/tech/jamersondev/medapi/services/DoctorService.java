package tech.jamersondev.medapi.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.jamersondev.medapi.domain.Doctor;
import tech.jamersondev.medapi.domain.records.DoctorList;
import tech.jamersondev.medapi.domain.records.DoctorObject;
import tech.jamersondev.medapi.domain.records.DoctorUpdate;
import tech.jamersondev.medapi.repositorys.DoctorRepository;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor insertDoctor(DoctorObject doctorObj){
        return this.doctorRepository.save(new Doctor(doctorObj));
    }

    public Page<DoctorList> list(Pageable pageable){
        //return this.doctorRepository.findAll(pageable).stream().map(DoctorList::new).toList();
        //return this.doctorRepository.findAll(pageable).map(DoctorList::new);
        return this.doctorRepository.findAllByIsActiveTrue(pageable).map(DoctorList::new);
    }

    public Doctor update(DoctorUpdate doctorUpdate, UUID doctorUUID) {
        Doctor doctor = this.doctorRepository.getReferenceById(doctorUUID);
        doctor.updateInformations(doctorUpdate);
        return doctor;
    }

    //deleção física
    public void delete(UUID id){
        this.doctorRepository.deleteById(id);
    }

    //deleção lógica
    public void deleteLogic(UUID id){
        Doctor doctor = this.doctorRepository.getReferenceById(id);
        doctor.deleteLogic();
    }

    public Doctor findDoctorByUUID(UUID doctorUUID) {
        Doctor doctor = this.doctorRepository.getReferenceById(doctorUUID);
        return doctor;
    }
}
