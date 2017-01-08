package com.helciodasilva.servico.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helciodasilva.servico.api.model.Empresa;

/**
 * Repositório de Empresa.
 * 
 * @author Helcio da Silva
 * @since 07/01/2017
 */
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
