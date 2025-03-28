package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Contato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CON_FOR_ID")
    private Fornecedor conFornecedor;
    @Column(length = 55, name = "telefone", nullable = false)
    private String telefone;
    @Column(length = 100, name = "celular", nullable = false)
    private String celular;
    @Column(length = 255,name = "email", nullable = false)
    private String email;

    public Contato() {
    }

    public Contato(Long id, String telefone, String celular, String email) {
        this.id = id;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
