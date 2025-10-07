package com.senac.projeto3.config;

import com.senac.projeto3.dto.request.JogoDtoRequest;
import com.senac.projeto3.entity.Jogo;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }
}