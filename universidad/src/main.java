
import Entidades.*;
import AccesosDatos.*;
import java.time.LocalDate;
import java.time.Month;

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
      Alumno alm2 = new Alumno(4,42252141,"Sparoww","Jack",fecha,true);    
//          ad.modificarAlumno(alm2);
            ad.eliminarAlumno(alm2);
        
    }
    
}
