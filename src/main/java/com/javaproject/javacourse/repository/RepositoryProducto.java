package com.javaproject.javacourse.repository;

import com.javaproject.javacourse.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProducto extends JpaRepository<Producto, Long> {
}