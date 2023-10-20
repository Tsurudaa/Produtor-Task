package com.projetin.ProjProdutores.repository;

import  com.projetin.ProjProdutores.ModelProd.Produtor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutorRepository extends JpaRepository<Produtor, Integer> {
}
