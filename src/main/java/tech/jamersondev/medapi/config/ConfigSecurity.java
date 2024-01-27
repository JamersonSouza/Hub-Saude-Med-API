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

@Configuration
@EnableWebSecurity
public class ConfigSecurity {

    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception{
          return http
                  .headers(headers -> headers
                          .frameOptions(f -> f.sameOrigin()))
                  .csrf(c -> c.ignoringRequestMatchers("/h2").disable())
                  .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                  .authorizeHttpRequests((auth) ->
                          auth.requestMatchers("/h2/**").permitAll()
                              .requestMatchers(HttpMethod.POST,"/new-user", "/login").permitAll()
                          .anyRequest().authenticated())

                  .build();
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
