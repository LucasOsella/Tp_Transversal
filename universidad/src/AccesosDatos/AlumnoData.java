/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesosDatos;

import Entidades.*;
import java.sql.*;
import java.util.*;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Lucas
 */
public class AlumnoData {
    private Connection con=null;

    public AlumnoData() {
        con=Conexion.getConexion();
        
    }
    
    public void guardarAlumno(Alumno alumno){
        String sql="INSERT INTO `alumno`(`dni`, `apellido`, `nombre`, `fecha_nacimiento`, `estado`) VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFecha_nacimiento()));
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setId_alumno(rs.getInt("id_alumno"));
                JOptionPane.showMessageDialog(null, "Alumno añadido con exito");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder al tabla alumno "+e.getMessage());
        }        
    }
    
    public Alumno buscarAlumno(int id){
        Alumno alumno=null;
        
        String sql="SELECT dni, apellido, nombre, fecha_nacimiento FROM alumno WHERE id_alumno = ? AND estado = 1";
        PreparedStatement ps=null;
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeQuery();
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                alumno=new Alumno();
                 alumno.setId_alumno(id);
                 alumno.setDni(rs.getInt("dni"));
                 alumno.setApellido(rs.getString("apellido"));
                 alumno.setNombre(rs.getString("nombre"));
                 alumno.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                 alumno.setEstado(true); 
            }else{
                JOptionPane.showMessageDialog(null, "No existe el alumno");
                ps.close();
            }
                    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno "+e.getMessage());
        }
        return alumno;
    }
    
    
    public List<Alumno> listarAlumno(){
        List<Alumno> alumnos =new ArrayList<>();
            String sql="SELECT id_alumno, dni, apellido, nombre FROM alumno WHERE estado = 1";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){               
               Alumno alumno=new Alumno();
               alumno.setId_alumno(rs.getInt("id_alumno"));
               alumno.setDni(rs.getInt("dni"));
               alumno.setApellido(rs.getString("apellido"));
               alumno.setNombre(rs.getString("nombre"));
               alumnos.add(alumno);                                            
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puedo acceder a la tabla alumno");
        }
        return alumnos;    
    }
    
    public void modificarAlumno(Alumno alumno){
        String sql="UPDATE alumno SET dni=?, apellido=?, nombre=?,fecha_nacimiento=? WHERE id_alumno=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFecha_nacimiento()));
            ps.setInt(5, alumno.getId_alumno());
            
           int exito=ps.executeUpdate();
           
            if (exito==1) {
                JOptionPane.showMessageDialog(null, "Modificacion exitosa");
            }else{
            JOptionPane.showMessageDialog(null, "El alumno no exites");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
    
    }
    
    public void eliminarAlumno(Alumno alumno){
        String sql= "UPDATE alumno SET estado=0 WHERE id_alumno = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getId_alumno());
          int fila = ps.executeUpdate();
            if (fila==1) {
                JOptionPane.showMessageDialog(null, "Se elimino un alumno");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro al acceder a la tabla alumno");
        }
        
    }
}
