package tech.jamersondev.medapi.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import tech.jamersondev.medapi.domain.records.PatientList;
import tech.jamersondev.medapi.domain.records.PatientObject;
import tech.jamersondev.medapi.services.PatientService;

@RestController
@RequestMapping("patient")
public class PatientResource {

    private final PatientService patientService;

    public PatientResource(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public void savePatient(@RequestBody PatientObject patientObject){
        this.patientService.savePatient(patientObject);
    }

    @GetMapping
    public Page<PatientList> list(Pageable pageable){
       return this.patientService.listPatients(pageable);
    }

}
