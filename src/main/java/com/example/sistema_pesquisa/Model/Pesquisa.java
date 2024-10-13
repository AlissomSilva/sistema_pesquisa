package com.example.sistema_pesquisa.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    private LocalDate data;
    private int qntd_questoes;
    private String cidade;

    @OneToMany(mappedBy = "pesquisa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Questao> questoes = new ArrayList<>();

    @OneToMany(mappedBy = "pesquisa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pesquisador> pesquisadores = new ArrayList<>();

}
