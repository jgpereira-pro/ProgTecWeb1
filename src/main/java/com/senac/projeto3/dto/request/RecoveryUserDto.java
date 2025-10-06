package com.senac.projeto3.dto.request;

import com.senac.projeto3.entity.Role;

import java.util.List;

public record RecoveryUserDto(

        Long id,
        String email,
        List<Role> roles

) {
}