package tech.jamersondev.medapi.resources;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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



}
