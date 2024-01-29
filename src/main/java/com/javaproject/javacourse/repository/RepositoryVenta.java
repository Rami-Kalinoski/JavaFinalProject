package com.javaproject.javacourse.repository;

import com.javaproject.javacourse.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryVenta extends JpaRepository<Venta, Long> {
}