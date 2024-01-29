package com.javaproject.javacourse.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table (name = "producto")
@Data
public class Producto {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private float precio;
    private int stock;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Venta> ventas;
}