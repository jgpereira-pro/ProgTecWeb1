package com.senac.projeto3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="inscricao")
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="inscricao_id")
    private int id;
    @Column(name="inscricao_data")
    private LocalDateTime data;
    @Column(name="inscricao_status")
    private int status;

    @ManyToOne
    @JoinColumn(name = "participante_id", nullable = false)
    @JsonIgnore
    private Participante participante;
    @ManyToOne
    @JoinColumn(name = "jogo_id", nullable = false)
    @JsonIgnore
    private Jogo jogo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

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
}