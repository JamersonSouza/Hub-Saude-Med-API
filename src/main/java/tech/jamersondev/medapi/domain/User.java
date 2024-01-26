package tech.jamersondev.medapi.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "userSystem")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userIdentifier;
    private String login;
    private String password;

    public UUID getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(UUID userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
