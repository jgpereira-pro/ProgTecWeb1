package com.senac.projeto3.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="categoria")
public class Categoria {
    @Id
    @GeneratedValue
    @Column(name="categoria_id")
    private int id;

    @Column(name="categoria_nome",nullable = false,length = 30)
    private String nome;

    @Column(name="categoria_status",nullable = false)
    private int status;

    @OneToMany(mappedBy = "categoria")
    private List<Jogo> jogos;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }
}