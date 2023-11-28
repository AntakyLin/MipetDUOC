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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
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
                ma.setNombre(rs.getString(1));
                ma.setFec_nac(rs.getDate(2));
                ma.setVigente(rs.getBoolean(3));
                ma.setChip(rs.getInt(4));
                ma.setRaza(rs.getString(5));
                ma.setEdad(rs.getInt(6));
                ma.setSexo(rs.getString(7));
                /*ma.setTipomascotas(rs.getInt(8));
                ma.setCliente(rs.getString(9));*/
            }
            rs.close(); 
            stmt.close(); 
            return codigo;
        } catch (SQLException ex) {
           return codigo; 
        }
    }
    public boolean modificar(Mascotas ma) {
        Conexion con= new Conexion();
        Connection conn=con.conectarBD("mipet");
        PreparedStatement stmt;
        String query = "update cliente set nombre=?,fec_nac=?,raza=?,edad=? where rut=?";
        DateFormat df = new SimpleDateFormat("yyyy-M-d");
        String fecha = df.format(ma.getFec_nac());
        try {            
            stmt = conn.prepareStatement(query);
            stmt.setString(1,ma.getNombre());
            stmt.setDate(2, java.sql.Date.valueOf(fecha));
            stmt.setBoolean(3, ma.isVigente());
            stmt.setInt(4, ma.getEdad());
            stmt.setInt(5,ma.getChip());
            stmt.setString(6,ma.getSexo());
            stmt.setString(7,ma.getRaza());
           /* stmt.setInt(8,ma.getTipomascotas());
            stmt.setString(9,ma.getCliente());*/
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }     
    }
    public boolean eliminar(Mascotas ma) {
        Conexion con= new Conexion();
        Connection conn=con.conectarBD("mipet");
        PreparedStatement stmt;
        String query = "delete from cliente where rut=?";
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1,ma.getNombre());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CrudCliente.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return false;
    }   
    public DefaultTableModel listarClientes(int opc) {
        Statement stmt;
        ResultSet rs;
        Conexion con= new Conexion();
        Connection conn=con.conectarBD("mipet");
        try {
            stmt = conn.createStatement(); 
            if (opc==-1)
                rs = stmt.executeQuery("select rut,nombre,fecnac,cv,descripcion from cliente c join profesion p where codpro=cod_pro");
            else
                rs = stmt.executeQuery("select rut,nombre,fecnac,cv,descripcion from cliente c join profesion p where codpro=cod_pro and codpro="+opc);              
            DefaultTableModel DT=new DefaultTableModel();
            DT.addColumn("Rut");
            DT.addColumn("Nombre");
            DT.addColumn("Fecha Nacimiento");
            DT.addColumn("CV Actualizado");
            DT.addColumn("Profesion");
            Object[] fila=new Object[5];
            while (rs.next()) { 
                fila[0]=rs.getString(1);
                fila[1]=rs.getString(2);
                String fecha=new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate(3));
                fila[2]=fecha;
                if (rs.getBoolean("cv"))
                    fila[3]="Si";
                else{
                    fila[3]="No";
                }
                fila[4]=rs.getString(5);
                DT.addRow(fila);
            }
            rs.close(); 
            stmt.close(); 
            return(DT);
        } catch (SQLException ex) {
            return null;
        }
    }    
}
    
