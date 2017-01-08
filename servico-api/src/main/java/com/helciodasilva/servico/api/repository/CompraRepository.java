package com.helciodasilva.servico.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helciodasilva.servico.api.model.Compra;

/**
 * Repositório de Comopra.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
public interface CompraRepository extends JpaRepository<Compra, Long>{
}
