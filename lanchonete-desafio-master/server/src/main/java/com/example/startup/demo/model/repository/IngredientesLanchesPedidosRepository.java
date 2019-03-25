package com.example.startup.demo.model.repository;

import com.example.startup.demo.model.entities.IngredientesLanchesPedidos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientesLanchesPedidosRepository extends CrudRepository<IngredientesLanchesPedidos, Long> {

}