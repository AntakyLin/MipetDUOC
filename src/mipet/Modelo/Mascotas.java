/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mipet.Modelo;

import java.util.Date;

/**
 *
 * @author Paulina Muñoz
 */
public class Mascotas {
    private String nombre;
    private String raza;
    private int edad;
    private Date fec_nac;
    private String sexo;
    private int chip;
    private boolean vigente;
    private TipoMascotas tipomascotas;
    private Cliente cliente;

    public Mascotas() {
    }

    public Mascotas(String nombre, String raza, int edad, Date fec_nac, String sexo, int chip, boolean vigente, TipoMascotas tipomascotas, Cliente cliente) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.fec_nac = fec_nac;
        this.sexo = sexo;
        this.chip = chip;
        this.vigente = vigente;
        this.tipomascotas = tipomascotas;
        this.cliente = cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFec_nac() {
        return fec_nac;
    }

    public void setFec_nac(Date fec_nac) {
        this.fec_nac = fec_nac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getChip() {
        return chip;
    }

    public void setChip(int chip) {
        this.chip = chip;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public TipoMascotas getTipomascotas() {
        return tipomascotas;
    }

    public void setTipomascotas(TipoMascotas tipomascotas) {
        this.tipomascotas = tipomascotas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
