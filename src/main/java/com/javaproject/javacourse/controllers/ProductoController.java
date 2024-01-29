package com.javaproject.javacourse.controllers;

import com.javaproject.javacourse.models.Producto;
import com.javaproject.javacourse.repository.RepositoryProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {
    @Autowired
    private RepositoryProducto repo;

    // MÉTODO GET ------------------------------------------------------
    @GetMapping("productos/index")
    public String index(){
        return "Conectado";
    }

    @GetMapping("productos/listar")
    public List<Producto> getProductos(){
        return  repo.findAll();
    }

    // MÉTODO POST -----------------------------------------------------
    @PostMapping("producto/nuevo")
    public String postProductos(@RequestBody Producto producto){
        repo.save(producto);
        return "Producto nuevo guardado";
    }

    // MÉTODO PUT -------------------------------------------------------
    @PutMapping("producto/modificar/{id}")
    public String updateProductos(@PathVariable Long id, @RequestBody Producto producto) {
        Producto updateProducto = repo.findById(id).get();
        if (updateProducto!=null) {
            updateProducto.setModelo(producto.getModelo());
            updateProducto.setPrecio(producto.getPrecio());
            updateProducto.setStock(producto.getStock());
            repo.save(updateProducto);
            return "Producto modificado";
        } else {
            return "Producto no encontrado";
        }
    }

    // MÉTODO DELETE -----------------------------------------------------
    @DeleteMapping("producto/eliminar/{id}")
    public String deleteProductos(@PathVariable Long id){
        Producto deleteProducto = repo.findById(id).get();
        if (deleteProducto!=null) {
            repo.delete(deleteProducto);
            return "Producto eliminado";
        } else {
            return "Producto no encontrado";
        }
    }
}