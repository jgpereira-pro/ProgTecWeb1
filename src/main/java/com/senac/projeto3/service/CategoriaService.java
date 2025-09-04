package com.senac.projeto3.service;

import com.senac.projeto3.dto.request.CategoriaDtoRequest;
import com.senac.projeto3.dto.response.CategoriaDtoResponse;
import com.senac.projeto3.entity.Categoria;
import com.senac.projeto3.repository.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private ModelMapper modelMapper;

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarCategorias(){
        return this.categoriaRepository.listarCategoriasAtivas();
    }

    public Categoria listarCategoriaPorId(int idCategoria){
        return this.categoriaRepository.obterCategoriaAtivaPorId(idCategoria);
    }

    public CategoriaDtoResponse salvar(CategoriaDtoRequest categoriaDtoRequest){
        Categoria categoria = modelMapper.map(categoriaDtoRequest, Categoria.class);
        categoria.setStatus(1);

        Categoria categoriaSalva = this.categoriaRepository.save(categoria);

        return modelMapper.map(categoriaSalva, CategoriaDtoResponse.class);
    }

    public CategoriaDtoResponse atualizar(Integer idCategoria, CategoriaDtoRequest categoriaDtoRequest) {
        Categoria categoria = this.listarCategoriaPorId(idCategoria);
        if (categoria != null){
            modelMapper.map(categoriaDtoRequest, categoria);
            Categoria categoriaTemp = this.categoriaRepository.save(categoria);

            return modelMapper.map(categoriaTemp, CategoriaDtoResponse.class);
        }else{
            return null;
        }
    }


    public void apagar(Integer idCategoria){
        Categoria categoria = listarCategoriaPorId(idCategoria);
        if (categoria != null) {
            this.categoriaRepository.apagadorLogico(idCategoria);
        }else{
            System.out.println("Id não existe no banco de dados.");
        }
    }


}