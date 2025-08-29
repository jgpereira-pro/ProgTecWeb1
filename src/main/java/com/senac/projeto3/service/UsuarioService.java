package com.senac.projeto3.service;

import com.senac.projeto3.dto.responsive.UsuarioDtoResponsive;
import com.senac.projeto3.entity.Usuario;
import com.senac.projeto3.repository.UsuarioRepository;
import com.senac.projeto3.dto.request.UsuarioDtoRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private ModelMapper modelMapper;

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios(){
        return this.usuarioRepository.findAll();
    }

    public Usuario listarUsuarioPorId(int idUsuario){
        return this.usuarioRepository.findById(idUsuario).orElse(null);
    }

    public UsuarioDtoResponsive salvar(UsuarioDtoRequest usuarioDtoRequest) {

        Usuario usuario = modelMapper.map(usuarioDtoRequest, Usuario.class);
        usuario.setStatus(1);

        Usuario usuarioSave = this.usuarioRepository.save(usuario);

        return modelMapper.map(usuarioSave, UsuarioDtoResponsive.class);
    }
}