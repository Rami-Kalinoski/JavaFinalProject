package com.javaproject.javacourse.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table (name="cliente")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Venta> ventas;
}