package com.example.startup.demo.model.CalculadorasDePromocao;

import com.example.startup.demo.model.entities.LanchesPedidos;

public class PromocaoLight implements Promocao {

    public double calcula(LanchesPedidos lanche){
        return lanche.getValorTotal() * 0.1;
    }
}
