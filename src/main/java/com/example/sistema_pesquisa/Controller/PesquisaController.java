package com.example.sistema_pesquisa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.sistema_pesquisa.Model.Pesquisa;
import com.example.sistema_pesquisa.Service.PesquisaService;

import java.util.List;

@RestController
@RequestMapping("/api/pesquisas")
public class PesquisaController {
    @Autowired
    private PesquisaService pesquisaService;

    @GetMapping
    public List<Pesquisa> listarPesquisas() {
        return pesquisaService.listarPesquisas();
    }

    @PostMapping
    public Pesquisa criarPesquisa(@RequestBody Pesquisa pesquisa) {
        return pesquisaService.criarPesquisa(pesquisa);
    }

    // Outros métodos (PUT, DELETE) para editar e deletar pesquisas
}
