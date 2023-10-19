package com.projetin.ProjProdutores.ControllerProd;


import com.projetin.ProjProdutores.ModelProd.Produtor;
import com.projetin.ProjProdutores.ServiceProd.ServiceProdutores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class ControllerProd {

    private static final String FORMULARIO_BOASVINDAS = "Luv2Mob - Registro de Produtores";
    private static final String LISTA_BOASVINDAS = "Luv2Mob - Lista de Produtores";
    @Autowired
    private ServiceProdutores service;

    @RequestMapping("/")
    public String iniciar (Produtor produtor, Model model){
        model.addAttribute("boasVindas", "Luv2Mob - Registro de Produtores");
        return "create";
    }

    @PostMapping("salvar")
    public String salvar(Produtor produtor, Model model) {
        service.salvarProd(produtor);
            return "redirect:/lista";
    }

    @GetMapping("/lista")
    public String listar(Model model) {
        model.addAttribute("boasVindas", LISTA_BOASVINDAS);
        model.addAttribute("listaProdutores", service.listarAll());
            return "lista";
    }

    @GetMapping("alterar/{Id}")
    public String alterar(@PathVariable Long Id, Model model) {
        model.addAttribute("boasVindas", FORMULARIO_BOASVINDAS);
        Produtor produtor = service.buscarPorId(Id);
        model.addAttribute("produtor", produtor);
        return "create";
    }

    @PostMapping("remover")
    public String remover(@RequestParam Long id) {
        service.removerPorId(id);
        return "redirect:/lista";
    }
}
