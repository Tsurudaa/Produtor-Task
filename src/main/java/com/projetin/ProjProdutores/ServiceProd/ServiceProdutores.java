package com.projetin.ProjProdutores.ServiceProd;

import com.projetin.ProjProdutores.ModelProd.Produtor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetin.ProjProdutores.repository.ProdutorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ServiceProdutores {

    @Autowired
    private ProdutorRepository produtorRepository;

    public void salvarProd(Produtor produtor) {
        produtorRepository.save(produtor);

    }

    public List<Produtor> listarAll() {
        return produtorRepository.findAll();
    }

    public Produtor buscarPorId(Integer id) {
        return produtorRepository.findById(id).get();
    }

    public void removerPorId(Produtor produtor) {
            produtorRepository.delete(produtor);
        }
}