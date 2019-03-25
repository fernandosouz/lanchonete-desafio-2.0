package com.example.startup.demo.model.repository;

import com.example.startup.demo.model.entities.dados.Ingrediente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends CrudRepository<Ingrediente, Long> {

}