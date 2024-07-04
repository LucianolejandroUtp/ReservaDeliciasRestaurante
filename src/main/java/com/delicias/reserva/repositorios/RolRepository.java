package com.delicias.reserva.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delicias.reserva.modelos.Roles;

@Repository
public interface RolRepository extends JpaRepository<Roles, Long>{

}
