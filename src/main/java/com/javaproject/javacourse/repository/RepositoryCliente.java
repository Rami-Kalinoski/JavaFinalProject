package com.javaproject.javacourse.repository;

import com.javaproject.javacourse.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCliente extends JpaRepository<Cliente, Long> {
}