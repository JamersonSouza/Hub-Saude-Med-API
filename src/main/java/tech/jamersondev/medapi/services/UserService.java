package tech.jamersondev.medapi.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tech.jamersondev.medapi.domain.User;
import tech.jamersondev.medapi.domain.records.LoginObject;
import tech.jamersondev.medapi.repositorys.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public User save(LoginObject user) {
        return this.userRepository.save(new User(user));
    }
}
