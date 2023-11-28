/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mipet.Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import mipet.Conexion;
import mipet.Modelo.Cliente;
import mipet.Modelo.Mascotas;



/**
 *
 * @author Paulina Muñoz
 */
public class CrudMascotas {
    public boolean agregar(Mascotas ma) {
        Conexion con= new Conexion();
        Connection conn=con.conectarBD("mipet");
        PreparedStatement stmt;
        String query = "insert into cliente (raza,nombre,fec_nac,edad,sexo,chip,vigente,tipomascota,cliente) values (?,?,?,?,?)";
        DateFormat df = new SimpleDateFormat("yyyy-M-d");
        String fecha = df.format(ma.getFec_nac());
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1,ma.getRaza());
            stmt.setString(2,ma.getNombre());
            stmt.setDate(3, java.sql.Date.valueOf(fecha));
            stmt.setBoolean(4, ma.isVigente());
            stmt.setInt(5, ma.getEdad());
            stmt.setInt(6,ma.getChip());
          /*  stmt.setTipoMascotas(7,ma.getTipomascotas());
            stmt.setCliente(8,ma.getCliente()); */
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public String buscar(Mascotas ma) {
        Statement stmt;
        ResultSet rs;
        Conexion con= new Conexion();
        Connection conn=con.conectarBD("mipet");
        String codigo="-1";
        Cliente cliente=new Cliente();
        try {
            stmt = conn.createStatement(); 
            rs = stmt.executeQuery("select raza,nombre,fec_nac,edad,codpro from cliente where rut='"+ma.getChip()+"'");
            while (rs.next()) { 
                ma.setNombre(rs.getString(2));
                ma.setFec_nac(rs.getDate(3));
                ma.setVigente(rs.getBoolean(4));
                Codigo=ma.getChip();
                cliente.setnombre(rs.getNString(5));
                ma.setcliente(cliente); 
            }
            rs.close(); 
            stmt.close(); 
            return codigo;
        } catch (SQLException ex) {
           return codigo; 
        }
    }    
}
    
