package com.veterinaria.mascotas.repository;

import com.veterinaria.mascotas.entities.Mascotas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VeterinariaRepository extends JpaRepository<Mascotas, Integer> {
}
