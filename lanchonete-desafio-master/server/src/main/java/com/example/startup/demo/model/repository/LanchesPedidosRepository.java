package com.example.startup.demo.model.repository;

import com.example.startup.demo.model.entities.LanchesPedidos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanchesPedidosRepository extends CrudRepository<LanchesPedidos, Long> {

}