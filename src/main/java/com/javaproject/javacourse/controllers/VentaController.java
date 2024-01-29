package com.javaproject.javacourse.controllers;

import com.javaproject.javacourse.models.Venta;
import com.javaproject.javacourse.repository.RepositoryVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {
    @Autowired
    private RepositoryVenta repo;

    // MÉTODO GET --------------------------------------------------------------
    @GetMapping("ventas/index")
    public String index() { return "Conectado"; }

    @GetMapping("ventas/listar")
    public List<Venta> getVentas() { return repo.findAll(); }

    // MÉTODO POST -------------------------------------------------------------
    @PostMapping("venta/nueva")
    public String postVentas(@RequestBody Venta venta) {
        repo.save(venta);
        return "Venta nueva guardada";
    }

    // MÉTODO PUT ---------------------------------------------------------------
    @PutMapping("venta/modificar/{id}")
    public String updateVentas(@PathVariable Long id, @RequestBody Venta venta) {
        Venta updateVenta = repo.findById(id).get();
        if (updateVenta!=null) {
            updateVenta.setProducto(venta.getProducto());
            updateVenta.setCantidad(venta.getCantidad());
            updateVenta.setCliente(venta.getCliente());
            updateVenta.setFecha(venta.getFecha());
            updateVenta.setTotalVenta(venta.getTotalVenta());
            return "Venta modificada";
        } else {
            return "Venta no encontrada";
        }
    }

    // MÉTODO DELETE ------------------------------------------------------------
    @DeleteMapping("venta/eliminar/{id}")
    public String deleteVentas(@PathVariable Long id) {
        Venta deleteVenta = repo.findById(id).get();
        if (deleteVenta!=null) {
            repo.delete(deleteVenta);
            return "Venta eliminada";
        } else {
            return "Venta no encontrada";
        }
    }
}