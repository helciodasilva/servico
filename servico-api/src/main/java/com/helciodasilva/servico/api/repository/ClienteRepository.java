package com.helciodasilva.servico.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helciodasilva.servico.api.model.Cliente;

/**
 * Repositório de Cliente.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
