package tech.jamersondev.medapi.resources;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jamersondev.medapi.domain.records.PatientObject;

@RestController
@RequestMapping("patient")
public class PatientResource {
    @PostMapping
    public void savePatient(@RequestBody PatientObject patientObject){
        System.out.println(patientObject);
    }

}
