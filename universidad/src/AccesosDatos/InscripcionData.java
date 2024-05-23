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
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class InscripcionData {
    private Connection con =null;
    private MateriaData materia;
    private AlumnoData alumno;
    
    public InscripcionData(){
        con=Conexion.getConexion();
    }
    
    public void guardarInscripcion(Inscripcion inscripcion){
        String sql="INSERT INTO `inscripcion`(`nota`, `id_alumno`, `id_materia`) VALUES ('?,?,?')";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, inscripcion.getNota());
            ps.setInt(2, inscripcion.getAlumno().getId_alumno());
            ps.setInt(3, inscripcion.getMateria().getId_materia());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
                inscripcion.setId_inscripcion(rs.getInt("id_inscripcion"));
                JOptionPane.showMessageDialog(null, "Inscripcion añadida con exito");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Inscripcion");
        }
    }
    
    public List<Inscripcion> obtenerInscripciones(){
     String sql="SELECT `id_inscripcion`, `nota`, `id_alumno`, `id_materia` FROM `inscripcion` WHERE 1;";
     List<Inscripcion>inscripciones =new ArrayList();
     
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
               Inscripcion inscripcion =new Inscripcion();
               inscripcion.setId_inscripcion(rs.getInt("id_inscripcion"));
               inscripcion.setNota(rs.getInt("nota"));
               inscripcion.setAlumno(alumno.buscarAlumno(rs.getInt("id_alumno")));
               inscripcion.setMateria(materia.buscarMateria(rs.getInt("id_materia")));
               inscripciones.add(inscripcion);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Inscripcion");
        }
        return inscripciones;
    }
}
