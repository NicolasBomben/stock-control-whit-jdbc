package com.alura.controller;

import java.util.List;

import com.alura.dao.ProductoDAO;
import com.alura.factory.ConnectionFactory;
import com.alura.model.Categoria;
import com.alura.model.Producto;

public class ProductoController {

    private ProductoDAO productoDao;
    
    public ProductoController() {
        var factory = new ConnectionFactory();
        this.productoDao = new ProductoDAO(factory.recuperaConexion());
    }

    public int modificar(String nombre, String descripcion, Integer cantidad, Integer id) {
        return productoDao.modificar(nombre, descripcion, cantidad, id);
    }

    public int eliminar(Integer id) {
        return productoDao.eliminar(id);
    }

    public List<Producto> listar() {
        return productoDao.listar();
    }

    public void guardar(Producto producto, Integer categoriaId) {
        producto.setCategoriaId(categoriaId);
        productoDao.guardar(producto);
    }

    public List<Producto> listar(Categoria categoria) {
        return productoDao.listar(categoria);
    }

}