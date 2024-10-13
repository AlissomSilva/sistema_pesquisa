package com.example.sistema_pesquisa.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Alternativa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao; // Texto da alternativa

    @ManyToOne
    @JoinColumn(name = "questao_id")
    private Questao questao;
}
