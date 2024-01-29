package com.javaproject.javacourse.controllers;

import com.javaproject.javacourse.models.Cliente;
import com.javaproject.javacourse.repository.RepositoryCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    private RepositoryCliente repo;

    // MÉTODO GET ------------------------------------------------------
    @GetMapping("clientes/index")
    public String index(){
        return "Conectado";
    }

    @GetMapping("clientes/listar")
    public List<Cliente> getClientes(){
        return  repo.findAll();
    }

    // MÉTODO POST -----------------------------------------------------
    @PostMapping("cliente/nuevo")
    public String postClientes(@RequestBody Cliente cliente){
        repo.save(cliente);
        return "Cliente nuevo guardado";
    }

    // MÉTODO PUT -------------------------------------------------------
    @PutMapping("cliente/modificar/{id}")
    public String updateClientes(@PathVariable Long id, @RequestBody Cliente cliente){
        Cliente updateCliente = repo.findById(id).get();
        if (updateCliente!=null) {
            updateCliente.setNombre(cliente.getNombre());
            updateCliente.setEmail(cliente.getEmail());
            repo.save(updateCliente);
            return "Cliente modificado";
        } else {
            return "Cliente no encontrado";
        }
    }

    // MÉTODO DELETE -----------------------------------------------------
    @DeleteMapping("cliente/eliminar/{id}")
    public String deleteClientes(@PathVariable Long id){
        Cliente deleteCliente = repo.findById(id).get();
        if (deleteCliente!=null) {
            repo.delete(deleteCliente);
            return "Cliente eliminado";
        } else {
            return "Cliente no encontrado";
        }
    }
}