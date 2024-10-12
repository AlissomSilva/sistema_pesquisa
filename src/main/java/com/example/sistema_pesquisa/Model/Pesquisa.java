package com.example.sistema_pesquisa.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data // Gera automaticamente getters e setters, toString, equals, e hashCode
@NoArgsConstructor // Gera um construtor sem parâmetros
@Entity
public class Pesquisa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String data; // Se preferir, pode usar LocalDate
    private String cidade;
    private String tipoQuestao; // Você pode modificar para uma lista se preferir
    private String duracao;

    @OneToMany(mappedBy = "pesquisa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pesquisador> pesquisadores = new ArrayList<>();

}
