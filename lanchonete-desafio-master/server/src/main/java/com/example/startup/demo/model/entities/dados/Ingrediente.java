package com.example.startup.demo.model.entities.dados;

import com.example.startup.demo.model.entities.IngredientesLanchesPedidos;
import com.example.startup.demo.model.entities.LanchesPedidos;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ingrediente")
public class Ingrediente {

    @Id
    @GeneratedValue
    private Long id;

    private String descricao;

    private double valor;

    @OneToMany(mappedBy = "ingrediente")
    private List<IngredientesLanchesPedidos> ingredientesLanchesPedidos = new ArrayList<IngredientesLanchesPedidos>();

    @ManyToMany(mappedBy="ingredientes")
    private Set<Lanche> lanches = new HashSet<Lanche>();

    public Ingrediente() {
    }

    public Ingrediente(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<IngredientesLanchesPedidos> getIngredientesLanchesPedidos() {
        return ingredientesLanchesPedidos;
    }

    public void setIngredientesLanchesPedidos(List<IngredientesLanchesPedidos> ingredientesLanchesPedidos) {
        this.ingredientesLanchesPedidos = ingredientesLanchesPedidos;
    }
}
