package com.projetin.ProjProdutores.ServiceProd;

import com.projetin.ProjProdutores.ModelProd.Produtor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ServiceProdutores {
    private List<Produtor> produtores = new ArrayList<>();
    private Long contId = 0L;

    public void salvarProd(Produtor produtor) {
        if (Objects.isNull(produtor.getId())) {
            produtor.setId(++contId);
            produtores.add(produtor);
        } else {
            var oldProd = buscarPorId(produtor.getId());
            if (oldProd != null) {
                var index = produtores.indexOf(oldProd);
                produtores.set(index, produtor);
            }
        }
    }

    public List<Produtor> listarAll() {
        return produtores;
    }

    public Produtor buscarPorId(Long id) {
        for (Produtor produtor : produtores) {
            if (produtor.getId().equals(id)) {
                return produtor;
            }
        }
        return null;
    }

    public void removerPorId(Long id) {
        Produtor produtorARemover = null;
        for (Produtor produtor : produtores) {
            if (produtor.getId().equals(id)) {
                produtorARemover = produtor;
                break;
            }
        }

        if (produtorARemover != null) {
            produtores.remove(produtorARemover);
        }
    }
}