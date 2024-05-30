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
public class InscripcionData {
    private Connection con =null;
    private MateriaData materia;
    private AlumnoData alumno;
    
    public InscripcionData(){
        con=Conexion.getConexion();
    }
    
    public void guardarInscripcion(Inscripcion inscripcion){
        String sql="INSERT INTO `inscripcion`(`nota`, `id_alumno`, `id_materia`) VALUES (?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, inscripcion.getNota());
            ps.setInt(2, inscripcion.getAlumno().getId_alumno());
            ps.setInt(3, inscripcion.getMateria().getId_materia());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
                inscripcion.setId_inscripcion(rs.getInt("id_inscripcion"));
                JOptionPane.showMessageDialog(null, "Inscripcion añadida con exito");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Inscripcion "+e.getMessage());
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
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id){ //INSCRIPCIONES POR ALUMNO. 
        String sql = "SELECT * FROM inscripcion WHERE id_alumno = ?";
        List<Inscripcion> inscripciones = new ArrayList ();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
             Inscripcion ins = new Inscripcion();
             ins.setId_inscripcion(rs.getInt("id_inscripcion"));
             ins.setNota(rs.getInt("nota"));
             ins.setAlumno(alumno.buscarAlumno(rs.getInt("id_alumno")));
             ins.setMateria(materia.buscarMateria(rs.getInt("id_materia")));
             inscripciones.add(ins);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener inscripcion.");
        }
        return inscripciones;
    }
    
    public List<Materia> obtenerMateriasCursadas(int id){  //OBTENER MATERIAS CURSADAS.  
        List<Materia> materias = new ArrayList<Materia>();
        try {
        String sql = "SELECT inscripcion.id_materia, nombre, año FROM inscripcion ,"
                + "materia WHERE inscripcion.id_materia= materia.id_materia "
                + "AND inscripcion.id_alumno = ?;";
        
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Materia materia;
            while(rs.next()){
                materia = new Materia();
                materia.setId_materia(rs.getInt("id_materia"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al acceder a la tabla inscripcion.");
        }
        return materias;
    } 
    public List<Materia> obtenerMateriasNoCursadas(int id) { //MATERIAS NO CURSADAS.
       List<Materia> materias = new ArrayList();
      try {
           String sql= "SELECT * FROM materia WHERE estado= 1 AND id_materia NOT IN"
                   + "(SELECT id_materia FROM inscripcion WHERE id_alumno=?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Materia mate ;
            while(rs.next()){
             mate = new Materia();
             mate.setId_materia(rs.getInt("id_materia"));
             mate.setNombre(rs.getString("nombre"));
             mate.setAño(rs.getInt("año"));
             mate.setEstado(rs.getBoolean("estado"));
             materias.add(mate);
            }
            ps.close();
        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,"Error al acceder a Materias.");
        }
      return materias;
    } 
    
    //BORRRAR INSCRIPCIONES POR ID DE MATERIA Y ALUMNO.
    public void borrarInscripcionMateriaAlumno (int idalumno,int idmateria) {
       String sql = "DELETE FROM inscripcion WHERE id_alumno = ? AND id_materia = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idalumno);
            ps.setInt(2, idmateria);
            int filas = ps.executeUpdate();
            if(filas > 0){
               JOptionPane.showMessageDialog(null,"Inscripcion Borrada.");   
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla inscripcion.");
        }
    }
    
    public void actualizarNota (int idalumno,int idmateria, double nota) {
       String sql = "UPDATE inscripcion SET nota = ? WHERE id_alumno = ? AND id_materia = ?"; 
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1,nota);
            ps.setInt(2, idalumno);
            ps.setInt(3, idmateria);
          int filas =  ps.executeUpdate();
          if(filas>0){
              JOptionPane.showMessageDialog(null,"Nota Actualizada.");
          }
          ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla inscripcion.");
        }
    }
    public List<Alumno> obtenerAlumnosxMateria(int id_materia) {
        List<Alumno> alumnosmateria = new ArrayList ();
        String sql = "SELECT a.id_alumno, dni, nombre, apellido, fecha_nacimiento, estado "
                + "FROM inscripcion i,alumno a WHERE i.id_alumno = a.id_alumno AND id_materia=? AND a.estado= 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_materia);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Alumno alum = new Alumno();
                alum.setId_alumno(rs.getInt("id_alumno"));
                alum.setApellido(rs.getString("apellido"));
                alum.setNombre(rs.getString("nombre"));
                alum.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                alum.setEstado(rs.getBoolean("estado"));
                alumnosmateria.add(alum);
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al acceder a la tabla inscripcion.");
        }
        return alumnosmateria;
    }
}
