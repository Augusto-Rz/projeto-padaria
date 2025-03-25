package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(length = 55, name = "NOME", nullable = false)
    private String nome;
    @Column(name = "CPF", nullable = false)
    private String cpf;
    @Column(name = "DATANASCIMENTO", nullable = false)
    private LocalDate dataNacimento;

    @Column(length = 55, name = "STATUS", nullable = false)
    private String status;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String cpf, LocalDate dataNacimento, String status) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNacimento = dataNacimento;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNacimento() {
        return dataNacimento;
    }

    public void setDataNacimento(LocalDate dataNacimento) {
        this.dataNacimento = dataNacimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}