package com.example.sistema_pesquisa.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;



@Entity
@Data
@NoArgsConstructor
public class Pesquisador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @NotNull
    private String email;
    private String senha;
    private String nome;
    private String qnt_questoes_realizadas;

    @ManyToOne
    @JoinColumn(name = "pesquisa_id", nullable = false)
    private Pesquisa pesquisa;
}
