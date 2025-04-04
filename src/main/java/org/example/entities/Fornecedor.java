package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Fornecedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @OneToMany(mappedBy = "conFornecedor", cascade = CascadeType.ALL)
    private List<Contato> contatos = new ArrayList<>();

    @Column(name="RAZAO_SOCIAL")
    private String razaoSocial;

    @Column(name="NOME_FANTASIA")
    private String nomefantasia;

    @Column(name="CNPJ")
    private String cnpj;

    @Column(name="STATUS")
    private String status;

    public Fornecedor() {
    }

    public Fornecedor(Long id, String razaoSocial, String nomefantasia, String cnpj, String status) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.nomefantasia = nomefantasia;
        this.cnpj = cnpj;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        this.nomefantasia = nomefantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
}
