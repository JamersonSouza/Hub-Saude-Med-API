package tech.jamersondev.medapi.resources;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import tech.jamersondev.medapi.domain.Doctor;
import tech.jamersondev.medapi.domain.records.DoctorList;
import tech.jamersondev.medapi.domain.records.DoctorObject;
import tech.jamersondev.medapi.domain.records.DoctorUpdate;
import tech.jamersondev.medapi.domain.records.PatientObject;
import tech.jamersondev.medapi.services.DoctorService;

import java.net.URI;
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
    public ResponseEntity<DoctorObject> saveDoctor(@RequestBody @Valid DoctorObject doctorObject, UriComponentsBuilder uriBuilder) {
        Doctor doctor = this.doctorService.insertDoctor(doctorObject);
        URI uri = uriBuilder.path("/doctor/{id}").buildAndExpand(doctor.getDoctorIdentifier()).toUri();
        return ResponseEntity.created(uri).body(new DoctorObject(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<DoctorList>> list( @PageableDefault(size = 12, sort = {"nome"}) Pageable pageable){
        Page<DoctorList> list = this.doctorService.list(pageable);
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{doctorUUID}")
    @Transactional
    public ResponseEntity<DoctorList> update(@RequestBody @Valid DoctorUpdate doctorUpdate, @PathVariable UUID doctorUUID){
        Doctor updateDoctor = this.doctorService.update(doctorUpdate, doctorUUID);
        return ResponseEntity.ok(new DoctorList(updateDoctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Doctor> delete(@PathVariable UUID id){
        this.doctorService.deleteLogic(id);
        return ResponseEntity.noContent().build();
    }
}
