package tech.jamersondev.medapi.domain;

import jakarta.persistence.*;
import tech.jamersondev.medapi.domain.records.AddressObject;

import java.util.UUID;

@Embeddable
public class Address {

    private UUID addressIdentifier;
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String uf;
    private String cidade;

    public Address() {
    }

    public Address(UUID addressIdentifier, String logradouro, String bairro, String cep, String numero, String complemento, String uf, String cidade) {
        this.addressIdentifier = addressIdentifier;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.uf = uf;
        this.cidade = cidade;
    }

    public Address(AddressObject address) {
        this.addressIdentifier = UUID.randomUUID();
        this.logradouro = address.logradouro();
        this.bairro = address.bairro();
        this.cep = address.cep();
        this.numero = address.numero();
        this.complemento = address.complemento();
        this.uf = address.uf();
        this.cidade = address.cidade();
    }

    public UUID getAddressIdentifier() {
        return addressIdentifier;
    }

    public void setAddressIdentifier(UUID addressIdentifier) {
        this.addressIdentifier = addressIdentifier;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
