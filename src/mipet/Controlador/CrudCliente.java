/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mipet.Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mipet.Util.Conexion;
import javax.swing.table.TableModel;
import mipet.Conexion;
import mipet.Modelo.Cliente;





/**
 *
 * @author Paulina Muñoz
 */
public class CrudCliente {
    public boolean agregar(Cliente cli) {
        Conexion con= new Conexion();
        Connection conn=con.conectarBD("mipet");
        PreparedStatement stmt;
        String query = "insert into cliente (nombre,rut,appaterno,apmaterno) values (?,?,?,?,?)";
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1,cli.getRut());
            stmt.setString(2,cli.getNombre());
            stmt.setString(3, cli.getAppaterno());
            stmt.setString(4, cli.getApmaterno());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }     

    }
    
public boolean modificar(Cliente cli) {
        Conexion con= new Conexion();
        Connection conn=con.conectarBD("mipet");
        PreparedStatement stmt;
        String query = "update cliente set nombre=?,appaterno=?,apmaterno=?,where rut=?";
        try {            
            stmt = conn.prepareStatement(query);
            stmt.setString(1,cli.getNombre());
            stmt.setString(2, cli.getAppaterno());
            stmt.setString(3,cli.getApmaterno());
            stmt.setString(4,cli.getRut());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }     
    }       
public boolean eliminar(Cliente cli) {
        Conexion con= new Conexion();
        Connection conn=con.conectarBD("mipet");
        PreparedStatement stmt;
        String query = "delete from cliente where rut=?";
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1,cli.getRut());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CrudCliente.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return false;
    }     

    public TableModel listarMascotas(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
