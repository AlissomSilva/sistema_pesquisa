package com.example.sistema_pesquisa.Service;

import com.example.sistema_pesquisa.Interface.PesquisaRepository;
import com.example.sistema_pesquisa.Model.Pesquisa;
import com.example.sistema_pesquisa.Model.Pesquisador;
import com.example.sistema_pesquisa.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sistema_pesquisa.Interface.PesquisadorRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PesquisaService {
    @Autowired
    private PesquisaRepository pesquisaRepository;
    @Autowired
    private PesquisadorRepository pesquisadorRepository;

    public List<Pesquisa> listarPesquisas() {
        return pesquisaRepository.findAll();
    }

    public Pesquisa criarPesquisa(Pesquisa pesquisa) {
        // Aqui você pode adicionar validações se necessário
        return pesquisaRepository.save(pesquisa);
    }
    public boolean deletePesquisa(Long id) {
        if (pesquisaRepository.existsById(id)) {
            pesquisaRepository.deleteById(id);
            return true; // Retorna true se deletou
        }
        return false; // Retorna false se não encontrou
    }
    // Outros métodos para editar e deletar pesquisas
    public Pesquisa addPesquisadores(Long pesquisaId, List<String> emails) {
        Pesquisa pesquisa = pesquisaRepository.findById(pesquisaId)
                .orElseThrow(() -> new ResourceNotFoundException("Pesquisa não encontrada"));

        for (String email : emails) {
            Pesquisador pesquisador = new Pesquisador();
            pesquisador.setEmail(email);
            pesquisador.setPesquisa(pesquisa);
            pesquisa.getPesquisadores().add(pesquisador);
        }

        return pesquisaRepository.save(pesquisa);
    }

    public Pesquisa findById(Long id) {
        Optional<Pesquisa> pesquisaOptional = pesquisaRepository.findById(id);
        return pesquisaOptional.orElse(null); // Retorna null se não encontrar
    }
    public List<Pesquisador> listarPesquisadores(Long pesquisaId) {
        Pesquisa pesquisa = pesquisaRepository.findById(pesquisaId)
                .orElseThrow(() -> new ResourceNotFoundException("Pesquisa não encontrada"));

        return pesquisa.getPesquisadores(); // Retorna a lista de pesquisadores da pesquisa
    }
    public Pesquisador atualizarPesquisador(Long pesquisadorId, Pesquisador novosDados) {
        Pesquisador pesquisadorExistente = pesquisadorRepository.findById(pesquisadorId)
                .orElseThrow(() -> new ResourceNotFoundException("Pesquisador não encontrado"));

        // Atualiza os atributos fornecidos
        if (novosDados.getNome() != null) {
            pesquisadorExistente.setNome(novosDados.getNome());
        }
        if (novosDados.getEmail() != null) {
            pesquisadorExistente.setEmail(novosDados.getEmail());
        }
        // Adicione outras verificações para outros atributos que podem ser atualizados
        // Exemplo: senha, qnt_questoes_realizadas etc.

        return pesquisadorRepository.save(pesquisadorExistente); // Salva as mudanças
    }


}