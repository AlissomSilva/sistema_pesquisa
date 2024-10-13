package com.example.sistema_pesquisa.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enunciado; // O texto da pergunta
    private String tipo; // Pode ser "ABERTA" ou "MULTIPLA_ESCOLHA"

    @ManyToOne
    @JoinColumn(name = "pesquisa_id")
    private Pesquisa pesquisa;

    // Se for uma questão de múltipla escolha, terá alternativas
    @OneToMany(mappedBy = "questao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alternativa> alternativas = new ArrayList<>();
}
