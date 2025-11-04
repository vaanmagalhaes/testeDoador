package com.senac.doador.entity;

import jakarta.persistence.*;

@Entity
@Table(name="doador")
public class Doador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="doador_id")
    private int id;

    @Column(name="doador_nome", nullable = false)
    private String nome;

    @Column(name="doador_endereco")
    private String endereco;

    @Column(name="doador_status")
    private Integer status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
