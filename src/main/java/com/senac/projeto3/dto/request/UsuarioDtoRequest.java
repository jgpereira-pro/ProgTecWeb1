package com.senac.projeto3.dto.request;

import com.senac.projeto3.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class UsuarioDtoRequest {
    private String nome;
    private String cpf;
    private LocalDate datadenascimento;

    @Autowired
    private ModelMapper modelMapper;
    public Usuario converterParaEntidade(UsuarioDtoRequest usuarioDto) {
        return modelMapper.map(usuarioDto, Usuario.class);
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

    public LocalDate getDatadenascimento() {
        return datadenascimento;
    }

    public void setDatadenascimento(LocalDate datadenascimento) {
        this.datadenascimento = datadenascimento;
    }
}
