package com.example.startup.demo.model.entities.dados;

import com.example.startup.demo.model.entities.LanchesPedidos;
import org.decimal4j.util.DoubleRounder;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "lanche")
public class Lanche {

    @Id
    @GeneratedValue
    private Long id;

    private String descricao;

    private double valorTotal;

    @OneToMany(mappedBy = "lanche")
    private List<LanchesPedidos> lanchesPedidos = new ArrayList<LanchesPedidos>();

    /*Um lanche tem vários ingredientes e um ingrediente pode estar em vários lanches*/
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "lanches_ingredientes_default",
            joinColumns = { @JoinColumn(name = "lanche_id") },
            inverseJoinColumns = { @JoinColumn(name = "ingrediente_id") })
    private Set<Ingrediente> ingredientes = new HashSet<>();

    public Lanche(Long id) {
        this.id = id;
    }

    public Lanche() {
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

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = DoubleRounder.round(valorTotal, 2);
    }

    public List<LanchesPedidos> getLanchesPedidos() {
        return lanchesPedidos;
    }

    public void setLanchesPedidos(List<LanchesPedidos> lanchesPedidos) {
        this.lanchesPedidos = lanchesPedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lanche lanche = (Lanche) o;
        return Objects.equals(this.getId(), lanche.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}
