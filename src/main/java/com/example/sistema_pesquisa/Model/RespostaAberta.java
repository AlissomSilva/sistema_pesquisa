package com.example.sistema_pesquisa.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class RespostaAberta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "questao_id")
    private Questao questao;

    // Resposta aberta
    private String respostaTexto;

    // Se for uma questão de múltipla escolha, a resposta é uma alternativa
    @ManyToOne
    @JoinColumn(name = "alternativa_id", nullable = true)
    private Alternativa respostaAlternativa;
}
