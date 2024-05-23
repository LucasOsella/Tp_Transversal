/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesosDatos;

import Entidades.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        String sql="SELECT nombre, año FROM `materia` WHERE id_materia=? AND estado=1";
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
   
   public void modificarMateria(Materia materia) {
   String sql = "UPDATE materia SET nombre=?,año=? WHERE id_materia=?";
   
    try {
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, materia.getNombre());
           ps.setInt(2, materia.getAño());
           ps.setInt(3, materia.getId_materia());
           
           int exito = ps.executeUpdate();
           if(exito == 1){
             JOptionPane.showMessageDialog(null,"Modificacion exitosa");
           }
           else{
               JOptionPane.showMessageDialog(null,"El alumno no existe");
            }
              
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
       }
   
   }
   
   public void eliminarMateria(int id){
        try {
            String sql = "UPDATE materia SET estado=0 WHERE id_materia=? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            int fila = ps.executeUpdate();
            if(fila == 1){
            JOptionPane.showMessageDialog(null,"Materia eliminada con exito");
            } ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla materia");
      }}
   
   public List <Materia> listarMateria(){
   List<Materia> materias = new ArrayList<>();
   
   String sql = "SELECT id_materia ,nombre ,año FROM `materia` WHERE estado = 1";
   try{
   PreparedStatement ps = con.prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   while(rs.next()){
   Materia materia = new Materia();
   materia.setId_materia(rs.getInt("id_materia"));
   materia.setNombre(rs.getString("nombre"));
   materia.setAño(rs.getInt("año"));
   materias.add(materia);
   } 
   ps.close();
   }catch(SQLException e){
    JOptionPane.showMessageDialog(null, "No se puedo acceder a la tabla materia");
   }
        return materias;
   } 
   
   
   }

