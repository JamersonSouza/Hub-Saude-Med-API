package tech.jamersondev.medapi.resources;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.jamersondev.medapi.domain.Doctor;
import tech.jamersondev.medapi.domain.records.DoctorList;
import tech.jamersondev.medapi.domain.records.DoctorObject;
import tech.jamersondev.medapi.domain.records.DoctorUpdate;
import tech.jamersondev.medapi.domain.records.PatientObject;
import tech.jamersondev.medapi.services.DoctorService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("doctor")
public class DoctorResource {

    private final DoctorService doctorService;

    public DoctorResource(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    @Transactional
    public void saveDoctor(@RequestBody @Valid DoctorObject doctorObject) {
        this.doctorService.insertDoctor(doctorObject);
    }

    @GetMapping
    public Page<DoctorList> list( @PageableDefault(size = 12, sort = {"nome"}) Pageable pageable){
       return this.doctorService.list(pageable);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DoctorUpdate doctorUpdate){
        this.doctorService.update(doctorUpdate);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable UUID id){

    }
}
