package com.helciodasilva.servico.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helciodasilva.servico.api.model.Servico;

/**
 * Repositório de Servico.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
