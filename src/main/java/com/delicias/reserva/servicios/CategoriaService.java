package com.delicias.reserva.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delicias.reserva.modelos.Categorias;
import com.delicias.reserva.repositorios.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categorias> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Categorias getCategoriaById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public void saveCategoria(Categorias categoria) {
        categoriaRepository.save(categoria);
    }

    public void updateCategoria(Categorias categoria) {
        categoriaRepository.save(categoria);
    }

    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
