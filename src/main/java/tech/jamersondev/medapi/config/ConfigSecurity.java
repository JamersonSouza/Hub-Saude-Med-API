package tech.jamersondev.medapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import tech.jamersondev.medapi.security.SecurityFilterJWT;

@Configuration
@EnableWebSecurity
public class ConfigSecurity {

    private SecurityFilterJWT securityFilterJWT;

    public ConfigSecurity(SecurityFilterJWT securityFilterJWT) {
        this.securityFilterJWT = securityFilterJWT;
    }

    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception{
                  http.headers(headers -> headers
                          .frameOptions(f -> f.sameOrigin()))
                  .csrf(c -> c.disable())
                  .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                  .authorizeHttpRequests(req -> {
                    req.requestMatchers("/new-user", "/login",
                            "/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll();
                    req.anyRequest().authenticated();
                  })
                  .addFilterBefore(securityFilterJWT, UsernamePasswordAuthenticationFilter.class);
                return http.build();
    }

    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration authConfiguration) throws Exception {
     return authConfiguration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
