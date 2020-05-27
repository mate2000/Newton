/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newton;

import DataBase.consultas;
import DataBase.Mision;
import java.util.LinkedList;

/**
 *
 * @author MateoMA
 */
public class Main {

    
    public static void main(String[] args) {
        
        
       String consulta1 [][]= consultas.RegistrosObervacion(); 
       String consulta2 [][]= consultas.PersonalMision("'apollo 11'");
       String consulta3 [][]=  consultas.EntidadesAfiliadas("'Estacion espacial InTeRnACiOnAl'");
       Mision mision = consultas.informacionMision("'sonda solar parker'");
       LinkedList<String> list = consultas.categoriasMision("'ApOlLo 11'");
       LinkedList<String> list2 = consultas.especializacionPersonal("'SoNdA sOlAr PaRkEr'");
       LinkedList<String> list3 = consultas.tareasEntidad("'SoNdA sOlAr PaRkEr'");
       LinkedList<String> list4 = consultas.tareasEntidad("'estacion espacial internacional'");
        //System.out.println(""+consultas.loginUsuario(3));
        //consultas.ingresarMision("'Mir'", "'4.2 billones'", "'Completada'", "'Crear el primer laboratorio en el espacio de la URSS'", "'1986-02-20'", "'2001-03-23'");
      // consultas.ingresarPersona("'Sara'","'2005-12-28'",1001539564);
     // consultas.ingresarPersonaMision("'jessie'","'1995-10-04'", 1121637889,"'fisica'");
        //consultas.ingresarEntidad("'Virgin Orbit'");
        // consultas.ingresarObservacion("'saturno'", "'Rionegro'", "'12:50 am'",1012538863);
      //  consultas.ingresarPersonalMision(1, 1121637889);
        //consultas.ingresarEntidadMision(4, 8);
        //  consultas.ingresarTareEntidad(6, "'Creaer el modulo de escape'");
       //  consultas.ingresarCategoriaMision(8,7);
        
        
       //consultas.consulta1();
       
        //consultas.consulta2("'sonda solar parker'");
       
       /* for (int i = 0; i < 4; i++) {
            for (int j = 0; j < consulta1[i].length; j++) {
                System.out.println(""+consulta1[i][j]);
            }
        }*/
 
    /* for (int i = 0; i < 3; i++) {
            for (int j = 0; j < consulta2[i].length; j++) {
                System.out.println(""+consulta2[i][j]);
            }
 
        }*/
       
     
       /* for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 4; j++) {
                
                System.out.println(""+consulta3[i][j]);
            }
        }*/
   
      /*for(int i=0;i<list4.size();i++){
       
          System.out.println(""+list4.get(i));
      
      }*/
       
       
       /* System.out.println(""+mision.getNombre());
        System.out.println(""+mision.getCoste());
        System.out.println(""+mision.getEstadoMision());
        System.out.println(""+mision.getObjetivoMision());
        System.out.println(""+mision.getFechaLanzamiento());
        System.out.println(""+mision.getFechaFinalizacion());*/
        
        
        /*for(int i=0;i< list.size();i++){
            System.out.println(list.get(i));
        }*/
        
        /* for(int i=0;i< list2.size();i++){
            System.out.println(list2.get(i));
        }*/
         
         /* for(int i=0;i< list3.size();i++){
            System.out.println(list3.get(i));
          }*/
    }
    
}
