package com.alura.controller;

import java.util.List;

import com.alura.dao.CategoriaDAO;
import com.alura.factory.ConnectionFactory;
import com.alura.model.Categoria;

public class CategoriaController {

    private CategoriaDAO categoriaDAO;

    public CategoriaController() {
        var factory = new ConnectionFactory();
        this.categoriaDAO = new CategoriaDAO(factory.recuperaConexion());
    }

    public List<Categoria> listar() {
        return this.categoriaDAO.listar();
    }

    public List<Categoria> cargaReporte() {
        return this.categoriaDAO.listarConProductos();
    }

}
