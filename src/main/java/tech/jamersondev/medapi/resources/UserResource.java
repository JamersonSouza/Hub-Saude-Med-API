package tech.jamersondev.medapi.resources;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tech.jamersondev.medapi.domain.User;
import tech.jamersondev.medapi.domain.records.LoginObject;
import tech.jamersondev.medapi.services.UserService;

import java.net.URI;

@RestController
@RequestMapping("/new-user")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<LoginObject> createNewUser(@RequestBody @Valid LoginObject user, UriComponentsBuilder uriBuilder){
        User user1 = this.userService.save(user);
        URI uri = uriBuilder.path("/user/{id}").buildAndExpand(user1.getUserIdentifier()).toUri();
        return ResponseEntity.ok().body(new LoginObject(user1));
    }
}
