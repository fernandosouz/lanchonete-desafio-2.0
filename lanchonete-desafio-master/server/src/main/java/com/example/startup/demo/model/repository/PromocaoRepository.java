package com.example.startup.demo.model.repository;

import com.example.startup.demo.model.entities.LanchesPedidos;
import com.example.startup.demo.model.entities.dados.Promocao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocaoRepository extends CrudRepository<Promocao, Long> {

}