package com.example.sistema_pesquisa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.sistema_pesquisa.Model.Pesquisa;
import com.example.sistema_pesquisa.Service.PesquisaService;
import org.springframework.http.ResponseEntity;


import java.util.List;

@RestController
@RequestMapping("/pesquisas")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePesquisa(@PathVariable Long id) {
        boolean isRemoved = pesquisaService.deletePesquisa(id);
        if (!isRemoved) {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrar a pesquisa
        }
        return ResponseEntity.noContent().build(); // Retorna 204 se deletar com sucesso
    }
    // Outros métodos (PUT, DELETE) para editar e deletar pesquisas
}
