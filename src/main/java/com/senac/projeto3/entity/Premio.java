package com.senac.projeto3.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "premio")
public class Premio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "premio_id")
    private int id;
    @Column(name = "premio_descricao", nullable = false, length = 300)
    private String descricao;
    @Column(name = "premio_ordem_premiacao", nullable = false)
    private int ordemPremiacao;
    @Column(name = "premio_categoria", nullable = false)
    private int categoriaId;
    @Column(name = "premio_status", nullable = false)
    private int status;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getOrdemPremiacao() {
        return ordemPremiacao;
    }
    public void setOrdemPremiacao(int ordemPremiacao) {
        this.ordemPremiacao = ordemPremiacao;
    }

    public int getCategoriaId() {
        return categoriaId;
    }
    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
