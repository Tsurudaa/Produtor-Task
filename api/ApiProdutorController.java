package com.projetin.ProjProdutores.api;

import com.projetin.ProjProdutores.ModelProd.Produtor;
import com.projetin.ProjProdutores.ServiceProd.ServiceProdutores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiProdutorController {

    @Autowired
    private ServiceProdutores serviceProdutores;

    @GetMapping("listar")
    public List<Produtor> produtorList() {
        return serviceProdutores.listarAll();
    }

    @GetMapping("listar/{id}")
    public Produtor listarPorId(@PathVariable(name = "id") Integer id) {
        return serviceProdutores.listarPorId(id);
    }
}
