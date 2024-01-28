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
import tech.jamersondev.medapi.services.HubSchedulingService;

@RestController
@RequestMapping("/hub-schedule")
public class HubSchedulingResource {

    private final HubSchedulingService schedulingService;

    public HubSchedulingResource(HubSchedulingService schedulingService) {
        this.schedulingService = schedulingService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<SchedulingDetailsResponse> scheduling(@RequestBody @Valid SchedulingDetails details){
        this.schedulingService.schedule(details);
        return ResponseEntity.ok(new SchedulingDetailsResponse(null, null,  null, null));
    }
}
