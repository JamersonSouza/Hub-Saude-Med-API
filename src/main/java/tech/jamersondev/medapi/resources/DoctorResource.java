package tech.jamersondev.medapi.resources;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jamersondev.medapi.domain.records.DoctorObject;
import tech.jamersondev.medapi.domain.records.PatientObject;
import tech.jamersondev.medapi.services.DoctorService;

@RestController
@RequestMapping("doctor")
public class DoctorResource {

    private final DoctorService doctorService;

    public DoctorResource(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public void saveDoctor(@RequestBody DoctorObject doctorObject) {
        this.doctorService.insertDoctor(doctorObject);
    }
}
