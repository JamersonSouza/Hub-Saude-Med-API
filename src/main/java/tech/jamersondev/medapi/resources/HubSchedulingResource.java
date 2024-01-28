package tech.jamersondev.medapi.resources;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jamersondev.medapi.domain.records.SchedulingDetails;
import tech.jamersondev.medapi.domain.records.SchedulingDetailsResponse;

@RestController
@RequestMapping("/hub-schedule")
public class HubSchedulingResource {

    @PostMapping
    @Transactional
    public ResponseEntity<SchedulingDetailsResponse> scheduling(@RequestBody @Valid SchedulingDetails details){
        System.out.println(details);
        return ResponseEntity.ok(new SchedulingDetailsResponse(null, null,  null, null));
    }
}
