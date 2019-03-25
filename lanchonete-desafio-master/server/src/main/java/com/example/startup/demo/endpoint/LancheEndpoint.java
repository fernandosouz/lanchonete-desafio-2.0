package com.example.startup.demo.endpoint;

import com.example.startup.demo.controllers.LancheController;
import com.example.startup.demo.model.entities.LanchesPedidos;
import com.example.startup.demo.model.entities.dados.Lanche;
import com.example.startup.demo.wrappers.LancheWrapperRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Criado por  Fernando Henrique de Souza on 23/02/19.
 */

/**
 * Classe que define os endpoints da entidade "Lanche"
 */
@CrossOrigin
@RestController
@RequestMapping("lanche")


/** Método que escuta requisições no path lanche/detalhesDoPedido e chama o método que aplica as alterações
 *
 * @author Fernando Henrique de Souza
 * @param wrapper Objeto enviado pelo client
 * @return Response com as alterações
 */
//TODO - Usar SWAGGER
@ResponseStatus(HttpStatus.OK)
public class LancheEndpoint {


    @RequestMapping(value="/detalhesDoPedido", method=RequestMethod.POST,consumes="application/json",produces="application/json")
    @ResponseBody
    public LanchesPedidos detalhesDoPedido(@RequestBody LancheWrapperRequest wrapper) {

        /*Montar Lanche*/
        LanchesPedidos lanchesPedidos = new LanchesPedidos();
        lanchesPedidos.setLanche(new Lanche(wrapper.getCodigoDoLanche()));

        LancheController lancheController = new LancheController(lanchesPedidos);
        return lancheController.aplicarAlteracoes(wrapper.getIngredientes());
    }
}
