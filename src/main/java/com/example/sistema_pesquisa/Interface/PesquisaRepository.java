package com.example.sistema_pesquisa.Interface;

import com.example.sistema_pesquisa.Model.Pesquisa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PesquisaRepository extends JpaRepository<Pesquisa, Long> {
}
