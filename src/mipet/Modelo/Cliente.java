/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mipet.Modelo;

/**
 *
 * @author Paulina Muñoz
 */
public class Cliente {
    private String nombre;
    private String rut;
    private String appaterno;
    private String apmaterno;

    public Cliente() {
    }

    public Cliente(String nombre, String rut, String appaterno, String apmaterno) {
        this.nombre = nombre;
        this.rut = rut;
        this.appaterno = appaterno;
        this.apmaterno = apmaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getAppaterno() {
        return appaterno;
    }

    public void setAppaterno(String appaterno) {
        this.appaterno = appaterno;
    }

    public String getApmaterno() {
        return apmaterno;
    }

    public void setApmaterno(String apmaterno) {
        this.apmaterno = apmaterno;
    }
            
}
