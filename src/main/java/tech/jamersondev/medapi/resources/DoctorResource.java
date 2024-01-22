package tech.jamersondev.medapi.resources;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jamersondev.medapi.domain.records.DoctorObject;
import tech.jamersondev.medapi.domain.records.PatientObject;

@RestController
@RequestMapping("doctor")
public class DoctorResource {

    @PostMapping
    public void saveDoctor(@RequestBody DoctorObject doctorObject) {
        System.out.println(doctorObject);
    }
}