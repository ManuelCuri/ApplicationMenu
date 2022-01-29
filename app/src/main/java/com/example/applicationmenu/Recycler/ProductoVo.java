package com.example.applicationmenu.Recycler;

import java.io.Serializable;

public class ProductoVo implements Serializable {

    private String nombre;
    private String info;
    private String precio;
    private int foto;

    public ProductoVo(){

    }

    public ProductoVo(String nombre, String info, String precio, int foto) {
        this.nombre = nombre;
        this.info = info;
        this.precio = precio;
        this.foto = foto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
