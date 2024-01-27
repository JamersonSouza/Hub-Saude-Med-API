package tech.jamersondev.medapi.domain.records;

import java.util.UUID;

public record UserObject(UUID userIdentifier, String login) {
}
