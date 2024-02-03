package tech.jamersondev.medapi.resources;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tech.jamersondev.medapi.domain.Patient;
import tech.jamersondev.medapi.domain.records.PatientList;
import tech.jamersondev.medapi.domain.records.PatientObject;
import tech.jamersondev.medapi.domain.records.PatientUpdate;
import tech.jamersondev.medapi.services.PatientService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@RestController
@RequestMapping("patient")
@SecurityRequirement(name = "bearer-key")
public class PatientResource {

    private final PatientService patientService;

    public PatientResource(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PatientObject> savePatient(@RequestBody PatientObject patientObject, UriComponentsBuilder uriBuilder){
        Patient patient = this.patientService.savePatient(patientObject);
        URI uri = uriBuilder.path("/patient/{id}").buildAndExpand(patient.getPatientIdentifier()).toUri();
        return ResponseEntity.created(uri).body(new PatientObject(patient));
    }

    @GetMapping
    public ResponseEntity<Page<PatientList>> list(Pageable pageable){
        Page<PatientList> patientLists = this.patientService.listPatients(pageable);
        return ResponseEntity.ok(patientLists);
    }

    @DeleteMapping("/{patientUUID}")
    @Transactional
    public ResponseEntity<PatientObject> deletePatient(@PathVariable UUID patientUUID){
        this.patientService.deleteLogic(patientUUID);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{patientUUID}")
    @Transactional
    public ResponseEntity<PatientList> updatePatient(@RequestBody @Valid PatientUpdate patientUpdate,
                                                       @PathVariable UUID patientUUID){
        Patient patient = this.patientService.updatePatient(patientUpdate, patientUUID);
        return ResponseEntity.ok().body(new PatientList(patient));
    }

    @GetMapping("/{patientUUID}")
    public ResponseEntity<PatientList> findPatientByUUID(@PathVariable UUID patientUUID){
        Patient patient = this.patientService.findPatientByUUID(patientUUID);
        return ResponseEntity.ok().body(new PatientList(patient));
    }
}
