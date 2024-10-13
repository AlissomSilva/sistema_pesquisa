package com.example.sistema_pesquisa.Interface;
import com.example.sistema_pesquisa.Model.Pesquisador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PesquisadorRepository extends JpaRepository<Pesquisador, Long> {
    // Você pode adicionar métodos de consulta customizados aqui, se necessário
}
