package com.senac.projeto3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "inscricao")
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inscricao_id")
    private int id;
    @Column(name = "inscricao_nome", nullable = false, length = 30)
    private String nome;
    @Column(name = "inscricao_status", nullable = false)
    private int status;

    @ManyToOne
    @JoinColumn(name = "jogo_id", nullable = false)
    @JsonIgnore
    private Jogo jogo;

    @ManyToOne
    @JoinColumn(name = "participante_id", nullable = false)
    @JsonIgnore
    private Participante participante;

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

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
}
