package tech.jamersondev.medapi.resources;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jamersondev.medapi.domain.records.LoginObject;

@RestController
@RequestMapping("/login")
public class LoginResource {

    private final AuthenticationManager authManager;

    public LoginResource(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

    @PostMapping
    public ResponseEntity<LoginObject> login(@RequestBody @Valid LoginObject login){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login.login(), login.password());
        Authentication authenticated = authManager.authenticate(token);
        return ResponseEntity.ok().build();
    }
}
