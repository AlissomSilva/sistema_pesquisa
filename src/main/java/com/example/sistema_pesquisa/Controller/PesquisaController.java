package com.example.sistema_pesquisa.Controller;

import com.example.sistema_pesquisa.Model.Pesquisador;
import com.example.sistema_pesquisa.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @PostMapping("/{id}/pesquisadores")
    public ResponseEntity<Pesquisa> addPesquisadores(@PathVariable Long id, @RequestBody List<String> emails) {
        Pesquisa pesquisa = pesquisaService.findById(id); // Verifique se a pesquisa existe
        if (pesquisa == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Retorna 404 se não existir
        }

        return ResponseEntity.ok(pesquisaService.addPesquisadores(id, emails));
    }
    @GetMapping("/{id}/pesquisadores")
    public ResponseEntity<List<Pesquisador>> getPesquisadores(@PathVariable Long id) {
        try {
            List<Pesquisador> pesquisadores = pesquisaService.listarPesquisadores(id); // Chama o método no Service
            return ResponseEntity.ok(pesquisadores); // Retorna a lista de pesquisadores
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Retorna 404 se não encontrar
        }
    }
    @PutMapping("/pesquisadores/{pesquisadorId}")
    public ResponseEntity<Pesquisador> atualizarPesquisador(@PathVariable Long pesquisadorId, @RequestBody Pesquisador novosDados) {
        try {
            Pesquisador pesquisadorAtualizado = pesquisaService.atualizarPesquisador(pesquisadorId, novosDados);
            return ResponseEntity.ok(pesquisadorAtualizado); // Retorna o pesquisador atualizado
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Retorna 404 se não encontrar o pesquisador
        }
    }




}
