package com.alura.model;

public class Producto {
    
    private Integer id;

    private String nombre;

    private String descripcion;

    private Integer cantidad;

    public Integer categoriaId;

    //constructor
    public Producto(String nombre, String descripcion, Integer cantidad){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }
    //constructor
    public Producto(Integer id, String nombre, String descripcion, Integer cantidad){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public Producto(int id, String nombre, int cantidad){
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    //getters y setters
    public Integer getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public Integer getCantidad(){
        return cantidad;
    }

    public void setCategoriaId(Integer categoriaId){
        this.categoriaId = categoriaId;
    }

    public Integer getCategoriaId(){
        return this.categoriaId;
    }

    public void setId(Integer id){
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format(
                "{ id: %d, nombre: %s, descripcion: %s, cantidad: %d }",
                this.id, this.nombre, this.descripcion, this.cantidad);
    }
}
