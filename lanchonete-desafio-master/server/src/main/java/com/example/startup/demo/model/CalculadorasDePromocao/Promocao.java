package com.example.startup.demo.model.CalculadorasDePromocao;

import com.example.startup.demo.model.entities.LanchesPedidos;

import java.util.HashMap;
import java.util.Map;

public interface Promocao {

    Map<Long, Promocao> mapadePromocoes = new HashMap<Long, Promocao>(){{
        put(1L, new PromocaoLight());
        put(2L, new PromocaoMuitaCarne());
        put(3L, new PromocaoMuitoQueijo());
    }};

    public double calcula(LanchesPedidos lanche);
}
