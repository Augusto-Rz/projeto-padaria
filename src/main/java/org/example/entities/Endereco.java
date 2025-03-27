package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Endereco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(length = 55, name = "País", nullable = false)
    private String pais;

    @Column(length = 55, name = "Estado", nullable = false)
    private String estado;

    @Column(length = 55, name = "Cidade", nullable = false)
    private String cidade;

    @Column(length = 55, name = "Bairro", nullable = false)
    private String bairro;

    @Column(length = 55, name = "Rua", nullable = false)
    private String rua;

    public Endereco() {
    }

    public Endereco(Long id, String pais, String estado, String cidade, String bairro, String rua) {
        this.id = id;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
}
