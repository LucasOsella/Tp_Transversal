/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesosDatos;

import Entidades.*;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class MateriaData {
    private Connection con =null;
    
    public MateriaData(){
        con=Conexion.getConexion();
    }
    
    public void guardarMateria(Materia materia){
    String sql="INSERT INTO `materia`(`nombre`, `año`, `estado`) VALUES (?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
            materia.setId_materia(rs.getInt("id_materia"));
                JOptionPane.showMessageDialog(null, "Materia añadida con exito");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR al acceder a la tabla materia");
        }
    
    }

    public Materia buscarMateria(int id){
        String sql="SELECT nombre, año FROM `materia` WHERE id_materia=1 AND estado=1";
        Materia materia=null;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeQuery();
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                materia=new Materia();
                materia.setId_materia(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materia.setEstado(true);
            }else{
            JOptionPane.showMessageDialog(null, "NO existe la materia");
            ps.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO se puede acceder a la tabla alumno");
        }
        return materia;
    }
    
}
