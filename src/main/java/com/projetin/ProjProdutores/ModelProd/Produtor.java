package com.projetin.ProjProdutores.ModelProd;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;



@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produtor {

        @EqualsAndHashCode.Include
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String Nome;
        private String Propriedade;
}