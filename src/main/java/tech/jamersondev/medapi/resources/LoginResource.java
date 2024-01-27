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
import tech.jamersondev.medapi.domain.User;
import tech.jamersondev.medapi.domain.records.LoginObject;
import tech.jamersondev.medapi.domain.records.TokenJWT;
import tech.jamersondev.medapi.services.TokenService;

@RestController
@RequestMapping("/login")
public class LoginResource {

    private final AuthenticationManager authManager;

    private final TokenService tokenService;

    public LoginResource(AuthenticationManager authManager, TokenService tokenService) {
        this.authManager = authManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<TokenJWT> login(@RequestBody @Valid LoginObject login){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login.login(), login.password());
        Authentication authenticated = authManager.authenticate(token);
        String tokenJWT = this.tokenService.generateToken((User) authenticated.getPrincipal());
        return ResponseEntity.ok(new TokenJWT(tokenJWT));
    }
}
