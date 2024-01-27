package tech.jamersondev.medapi.domain.records;

public record ErrorResponseObject(String dataHora, Integer status, String titulo, String mensagem) {
}
