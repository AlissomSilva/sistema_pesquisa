package com.example.sistema_pesquisa.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sistema_pesquisa.Interface.PesquisaRepository;
import com.example.sistema_pesquisa.Model.Pesquisa;

import java.util.List;

@Service
public class PesquisaService {
    @Autowired
    private PesquisaRepository pesquisaRepository;

    public List<Pesquisa> listarPesquisas() {
        return pesquisaRepository.findAll();
    }

    public Pesquisa criarPesquisa(Pesquisa pesquisa) {
        // Aqui você pode adicionar validações se necessário
        return pesquisaRepository.save(pesquisa);
    }

    // Outros métodos para editar e deletar pesquisas
}