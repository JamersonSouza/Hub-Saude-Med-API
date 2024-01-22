package tech.jamersondev.medapi.domain.records;

public record AddressObject(String logradouro, String bairro, String cep, String cidade, String uf,
                            String complemento, String numero) {
}
