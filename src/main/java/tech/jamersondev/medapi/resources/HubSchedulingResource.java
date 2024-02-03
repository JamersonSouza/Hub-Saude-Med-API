package tech.jamersondev.medapi.resources;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jamersondev.medapi.domain.HubScheduling;
import tech.jamersondev.medapi.domain.records.SchedulingDetails;
import tech.jamersondev.medapi.domain.records.SchedulingDetailsResponse;
import tech.jamersondev.medapi.services.HubSchedulingService;

@RestController
@RequestMapping("/hub-schedule")
@SecurityRequirement(name = "bearer-key")
public class HubSchedulingResource {

    private final HubSchedulingService schedulingService;

    public HubSchedulingResource(HubSchedulingService schedulingService) {
        this.schedulingService = schedulingService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<SchedulingDetailsResponse> scheduling(@RequestBody @Valid SchedulingDetails details) {
        HubScheduling schedule = this.schedulingService.schedule(details);
        return ResponseEntity.ok(new SchedulingDetailsResponse(schedule));
    }
}