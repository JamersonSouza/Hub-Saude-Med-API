package tech.jamersondev.medapi.domain.records;

import jakarta.validation.constraints.NotNull;
import tech.jamersondev.medapi.domain.User;

public record LoginObject(@NotNull String login, @NotNull String password) {
    public LoginObject(User user) {
        this(user.getLogin(), user.getPassword());
    }
}
