
import Entidades.*;
import AccesosDatos.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//         Conexion.getConexion();
        LocalDate fecha=LocalDate.of(2000, Month.MARCH, 4);
      
        Alumno alm = new Alumno(43252141,"Messi","Leonel",fecha,true);
       

        AlumnoData ad=new AlumnoData();

//          ad.guardarAlumno(alm);
//          System.out.println(ad.listarAlumno());
//          System.out.println(ad.buscarAlumno(1));
//      Alumno alm2 = new Alumno(4,42252141,"Sparoww","Jack",fecha,true);    
//          ad.modificarAlumno(alm2);
//            ad.eliminarAlumno(alm2);
        
        /* Alumno juan = new Alumno (12312312,"Ramirez","Juan",LocalDate.of(1999,04, 13),true);
         AlumnoData alu = new AlumnoData();  
        alu.guardarAlumno(juan); */
//      Alumno rodrigo= new Alumno(23707564,"Gil","Ramiro",LocalDate.of(2000, 03, 25),true);
//      AlumnoData alu1 = new AlumnoData();
//      alu1.guardarAlumno(rodrigo);
//      
      Materia mat= new Materia("Ingles",2,true);
      MateriaData md=new MateriaData();
     //   md.guardarMateria(mat);
      
    Alumno lucas=ad.buscarAlumno(1);
    Materia mate=md.buscarMateria(1);
    
      
      Inscripcion ins= new Inscripcion(0,lucas,mate);
      InscripcionData insD= new InscripcionData();
      //insD.guardarInscripcion(ins);
//      insD.actualizarNota(1, 1, 9);
      List <Materia> materias = insD.obtenerMateriasNoCursadas(1);
        for (Materia materia : materias) {
            System.out.println(materia);
        }
    }
    
}
