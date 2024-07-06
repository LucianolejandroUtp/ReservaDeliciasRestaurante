package com.delicias.reserva.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delicias.reserva.modelos.Categorias;

@Repository
public interface CategoriaRepository extends JpaRepository<Categorias, Long>{

}
