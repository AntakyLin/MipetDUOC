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
import mipet.Util.Conexion;
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
            stmt.setInt(7,ma.getTipomascotas().getCodigo());
            stmt.setString(8,ma.getCliente().getRut()); 
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
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
    public DefaultTableModel listarMascotas(int opc) {
        Statement stmt;
        ResultSet rs;
        Conexion con= new Conexion();
        Connection conn=con.conectarBD("mipet");
        try {
            stmt = conn.createStatement(); 
            if (opc==-1)
                rs = stmt.executeQuery("select * from mascota join cliente on mascota.rut_cliente=cliente.rut join tipo_mascota on mascota.tipo=tipo_mascota.id");
            else
                rs = stmt.executeQuery("select * from mascota join cliente on mascota.rut_cliente=cliente.rut join tipo_mascota on mascota.tipo=tipo_mascota.id where codigo="+opc);              
            DefaultTableModel DT=new DefaultTableModel();
            DT.addColumn("Chip");
            DT.addColumn("Nombre");
            DT.addColumn("Fecha Nacimiento");
            DT.addColumn("Vigente");
            DT.addColumn("Edad");
            DT.addColumn("Sexo");
            DT.addColumn("Tipo Mascotas");
            DT.addColumn("Rut Cliente");
            Object[] fila=new Object[8];
            while (rs.next()) { 
                fila[0]=rs.getInt(1);
                fila[1]=rs.getString(2);
                String fecha=new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate(3));
                fila[2]=fecha;
                if (rs.getBoolean("vigente"))
                    fila[3]="Si";
                else{
                    fila[3]="No";
                }
                fila[4]=fecha;
                fila[5]=rs.getString(4);
                fila[6]=rs.getString(8)+"-"+rs.getString(9);
                fila[7]=rs.getString(14);
                
                DT.addRow(fila);
            }
            rs.close(); 
            stmt.close(); 
            return(DT);
        } catch (SQLException ex) {
            return null;
        }
    }    

    public boolean listar(Mascotas ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    
