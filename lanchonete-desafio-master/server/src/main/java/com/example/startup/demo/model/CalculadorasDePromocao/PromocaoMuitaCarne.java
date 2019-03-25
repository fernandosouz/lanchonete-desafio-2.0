package com.example.startup.demo.model.CalculadorasDePromocao;

import com.example.startup.demo.model.entities.LanchesPedidos;
import com.example.startup.demo.model.entities.dados.Ingrediente;
import com.example.startup.demo.model.repository.IngredienteRepository;
import com.example.startup.demo.utils.Constantes;

public class PromocaoMuitaCarne implements Promocao {

    private IngredienteRepository ingredienteRepository;

    public double calcula(LanchesPedidos lanche){
        Ingrediente ingredienteHamburguerDeCarne = ingredienteRepository.findById(Constantes.CODIGO_HAMBURGUER_CARNE).get();
        int quantidade = (int) lanche.getIngredientes().stream().filter(
                o -> o.getIngrediente().equals(ingredienteHamburguerDeCarne)).findFirst().get()
                .getQuantidade() / 3;
        return (quantidade * Constantes.VALOR_HAMBURGUER_CARNE);
    }

}
