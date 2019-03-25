package com.example.startup.demo.model.repository;

import com.example.startup.demo.model.entities.LanchesPedidos;
import com.example.startup.demo.model.entities.dados.Lanche;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancheRepository extends CrudRepository<Lanche, Long> {

}