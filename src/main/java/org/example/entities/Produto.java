package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="DESCRICAO")
    private String descricao;

    @Column(name="PRECOCUSTO")
    private double precocusto;

    @Column(name="PRECOVENDA")
    private double precovenda;

    @Column(name="ESTOQUE")
    private int estoque;

    public Produto() {
    }

    public Produto(Long id, String descricao, double precocusto, double precovenda, int estoque) {
        this.id = id;
        this.descricao = descricao;
        this.precocusto = precocusto;
        this.precovenda = precovenda;
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecocusto() {
        return precocusto;
    }

    public void setPrecocusto(double precocusto) {
        this.precocusto = precocusto;
    }

    public double getPrecovenda() {
        return precovenda;
    }

    public void setPrecovenda(double precovenda) {
        this.precovenda = precovenda;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}