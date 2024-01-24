package tech.jamersondev.medapi.domain.records;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import tech.jamersondev.medapi.domain.Address;

public record AddressObject(@NotBlank(message = "{logradouro.not.null.or.blank}")
                            String logradouro,
                            @NotBlank(message = "{bairro.not.null.or.blank}")
                            String bairro,
                            @NotBlank(message = "{cep.not.null.or.blank}")
                            @Pattern(regexp = "\\d{8}")
                            String cep,
                            @NotBlank(message = "{cidade.not.null.or.blank}")
                            String cidade,
                            @NotBlank(message = "uf.not.null.or.blank")
                            String uf,
                            String complemento,
                            String numero) {

    public AddressObject (Address address){
        this(address.getLogradouro(), address.getBairro(), address.getCep(),
                address.getCidade(), address.getUf(), address.getComplemento(), address.getNumero());
    }
}
