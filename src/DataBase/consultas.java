/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.*;
import java.util.LinkedList;

/**
 *
 * @author MateoMA
 */
public  class   consultas {
   
   /**
     * Metodo que me retorna el numero de filas de la cualquier consulta  
     * @param consulta
     * @return numero de filas de la consulta 
     */
   private static int setNumRow(String consulta){
   
      int rowCount=0;
        
        try {
           
              ResultSet registro=DB.resultQuery(consulta);
              
             while(registro.next()){
               
                 rowCount=+registro.getRow();
                
             }
            
             //System.out.println(rowCount+"");
            
       } catch (Exception e) {
            System.out.println(e);
       }
        
       
    return rowCount;
   }
   
   /**
    * Metodo que añade al parametro String dos comillas simples -> "'texto'" 
    * @param nombreMision
    * @return String  
    */
   private static String convert(String nombreMision){
    
     char[] mision=nombreMision.toCharArray();
     String parseNombre="";
     
     for (int i = 0; i < mision.length; i++) {
            
            if(i==0){
              parseNombre+="'"; 
            }
            parseNombre+=mision[i];
            
            if(i==mision.length-1){
             parseNombre+="'";
            }
        }   
     return parseNombre;
    }
   
   
   /**
    * Metodo que  retorna todos los regisro ingresados en la base de datos 
    * @return un arreglo con la informacion de las observaciones de la base de datos 
    */
   public static String[][] RegistrosObervacion(){
        /*
          select nombre,objeto,lugar,hora from personal
             inner join observaciones on observaciones.idPersonal=personal.id
       */
        
        String consulta= "select nombre,objeto,lugar,hora from personal\n" +
                  "inner join observaciones on observaciones.idPersonal=personal.id";
        
        int Rownum = consultas.setNumRow(consulta);
        
        int i=1;
       
        String rowData[][]= new String[4][Rownum];
       
        try {
             ResultSet registro=DB.resultQuery(consulta);
             while(registro.next()){
                rowData[0][registro.getRow()-1]= registro.getString(i);
                rowData[1][registro.getRow()-1]= registro.getString(i+1);
                rowData[2][registro.getRow()-1]= registro.getString(i+2);
                rowData[3][registro.getRow()-1]= registro.getString(i+3); 
             }
       } catch (Exception e) {
            
            System.out.println(e);
         }
      return rowData;
   }
   
   
   /**
    * Metodo que me retorna la infomacion de todo el personal relacionado con una mision especifica 
    * @param nombreMision
    * @return un arreglo con la informacion del personal relacionada con una mision 
    */
   public static String[][] PersonalMision(String nombreMision){

    /*
       select personal.nombre,titulo,fechanacimiento 
          from personal
	 inner join personalmision on personalmision.idpersonal=personal.id
	 inner join misiones on misiones.id=personalmision.idmision
	 where lower(misiones.nombre) like lower('sonda solar parker')
    */
      
      nombreMision= consultas.convert(nombreMision);
    
      String consulta= "select personal.nombre,titulo,fechanacimiento \n" +
"        from personal\n" +
"	 inner join personalmision on personalmision.idpersonal=personal.id\n" +
"	 inner join misiones on misiones.id=personalmision.idmision\n" +
"	 where lower(misiones.nombre) like " + " lower( " + nombreMision + " ) "; 
        
        int Rownum = consultas.setNumRow(consulta);
        
        int i=1;
       
        String rowData[][]= new String[3][Rownum];
       
        try {
             ResultSet registro=DB.resultQuery(consulta);
             while(registro.next()){
                rowData[0][registro.getRow()-1]= registro.getString(i);
                rowData[1][registro.getRow()-1]= registro.getString(i+1);
                rowData[2][registro.getRow()-1]= registro.getString(i+2);
             }
       } catch (Exception e) {
            
            System.out.println(e);
         }
    return rowData;
   }
   
   
   /**
    * Metodo que me retorna la infomacion de todo las entodadesAfiliadas relacionado con una mision especifica 
    * @param nombreMision
    * @return un arreglo con las entidades afiliadas a una mision 
    */
   public static String[][] EntidadesAfiliadas(String nombreMision){
    /*
       select entidadafiliada.nombre
        from entidadafiliada
        inner join entidadesmision on entidadesmision.identidadafiliada=entidadafiliada.id 
        inner join misiones on misiones.id=entidadesmision.idmision
        where lower(misiones.nombre) like lower('sonda solar parker')
     */
    
      nombreMision=consultas.convert(nombreMision);
    
      String consulta= "select entidadafiliada.nombre\n" +
"        from entidadafiliada\n" +
"        inner join entidadesmision on entidadesmision.identidadafiliada=entidadafiliada.id \n" +
"        inner join misiones on misiones.id=entidadesmision.idmision\n" +
"        where lower(misiones.nombre) like "  +  " lower("+ nombreMision +")";
        
        int Rownum = consultas.setNumRow(consulta);
        
        int i=1;
       
        String rowData[][]= new String[1][Rownum];
       
        try {
             ResultSet registro=DB.resultQuery(consulta);
             while(registro.next()){
                rowData[0][registro.getRow()-1]= registro.getString(i);
             }
       } catch (Exception e) {
            
            System.out.println(e);
         }
    return rowData;
     
   }
   
   /**
    * Metodo que retorna una mision 
    * @param nombreMision
    * @return retorna un objeto tipo mision 
    */
   public static Mision informacionMision(String nombreMision){
     /*
        select nombre, estadomision, costemision, fechalanzamiento,fechafinalizacion,objetivomision
           from misiones
	   where lower(misiones.nombre) like lower('sonda solar parker')
       */
     
     nombreMision=consultas.convert(nombreMision);
     
     String consulta="select nombre, estadomision, costemision, fechalanzamiento,fechafinalizacion,objetivomision\n" +
"           from misiones\n" +
"	   where lower(misiones.nombre) like " + " lower("+ nombreMision +")";
     
         Mision mision=null;
       try {
           
           ResultSet registro = DB.resultQuery(consulta);
          
           while(registro.next()){
              mision = new Mision(registro.getString("nombre"),registro.getString("costemision"),
                      registro.getString("estadomision"),registro.getString("objetivomision"),
                   registro.getDate("fechalanzamiento"),registro.getDate("fechafinalizacion"));
           }
           
           
       } catch (Exception e) {
           
           System.out.println(e);
       }
       
       
     return mision;  
   }
   
   
   /**
    * Metodo que retorna las categorias a las que pertenece una mision 
    * @param nombreMision
    * @return retorna una LinkedList con las distintas categorias a las que pertenece una mision  
    */
   public static LinkedList<String> categoriasMision(String nombreMision){
   
      /*
       select categorias.categoria 
        from categorias
	inner join categoriamision on categoriaMision.idcategoria=categorias.id
	inner join misiones on misiones.id=categoriamision.idmision
	where lower(misiones.nombre) like lower('apollo 11')
       */ 
       
       nombreMision=consultas.convert(nombreMision);
      
        String consulta="select categorias.categoria \n" +
"        from categorias\n" +
"	inner join categoriamision on categoriaMision.idcategoria=categorias.id\n" +
"	inner join misiones on misiones.id=categoriamision.idmision\n" +
"	where lower(misiones.nombre) like "+ " lower("+ nombreMision +") ";
        
        LinkedList<String> listCategorias=new LinkedList<>();
        
        try {
            ResultSet registro = DB.resultQuery(consulta);
            while(registro.next()){
              listCategorias.add(registro.getString("categoria"));
            }
       } catch (Exception e) {
            System.out.println(e);
       }
     
    return listCategorias;
   }
   
  
   /**
    * Metodo que retorna una las diferetes especializaciones que tinene el personal relacioada con una mision 
    * @param nombreMision
    * @return retorna una LinkedList con las distintas especializaciones que tinene el personal
    */
   public static LinkedList<String> especializacionPersonal(String nombreMision){
   
      /*
             select  especializaciones.especializacion
          from especializaciones
	  inner join especializacionpersonal on especializacionpersonal.idespecializacion=especializaciones.id
	  inner join personal on personal.id=especializacionpersonal.idpersonal
	  inner join personalmision on personal.id=personalmision.idpersonal
	  inner join misiones on misiones.id=personalmision.idmision
	  where lower(misiones.nombre) like lower('ApOlLo 11')
	
       */ 
      
        nombreMision=consultas.convert(nombreMision);
      
        String consulta="   select  especializaciones.especializacion\n" +
"          from especializaciones\n" +
"	  inner join especializacionpersonal on especializacionpersonal.idespecializacion=especializaciones.id\n" +
"	  inner join personal on personal.id=especializacionpersonal.idpersonal\n" +
"	  inner join personalmision on personal.id=personalmision.idpersonal\n" +
"	  inner join misiones on misiones.id=personalmision.idmision\n" +
"	  where lower(misiones.nombre) like "+ " lower("+ nombreMision +")";
        
        LinkedList<String> listEspecializaciones=new LinkedList<>();
        
        try {
            ResultSet registro = DB.resultQuery(consulta);
            while(registro.next()){
              listEspecializaciones.add(registro.getString("especializacion"));
            }
       } catch (Exception e) {
            System.out.println(e);
       }
     
    return listEspecializaciones;
   }
  
   /**
    * Metodo que retorna las tareas que tienen las entidades afiliadas a una mision 
    * @param nombreMision
    * @return  retorna una LinkedList con las tareas que tienen las entidades afiliadas a una mision 
    */
   public static LinkedList<String> tareasEntidad(String nombreMision){
   
      /*
	 select tareasentidadafiliada.tarea
         from tareasentidadafiliada
	  inner join entidadesmision on entidadesmision.id=tareasentidadafiliada.identidadesmision
	  inner join misiones on misiones.id=entidadesmision.idmision
	  where lower(misiones.nombre) like lower('sonda solar parker')
       */ 
      
      nombreMision=consultas.convert(nombreMision);
      
        String consulta="select tareasentidadafiliada.tarea\n" +
"      from tareasentidadafiliada\n" +
"	  inner join entidadesmision on entidadesmision.id=tareasentidadafiliada.identidadesmision\n" +
"	  inner join misiones on misiones.id=entidadesmision.idmision\n" +
"	  where lower(misiones.nombre) like " + " lower("+ nombreMision +") ";
        
        LinkedList<String> listTareas=new LinkedList<>();
        
        try {
            ResultSet registro = DB.resultQuery(consulta);
            while(registro.next()){
              listTareas.add(registro.getString("tarea"));
            }
       } catch (Exception e) {
            System.out.println(e);
       }
     
    return listTareas;
   }
    
   
   /**
    * Metodo que verifica si una persona ya se ha registrado 
    * @param id
    * @return retorna true si el usuario existe en la base de datos, si no retorna false 
    */
   public static boolean loginUsuario(Integer id){
    
       /*
         select * from personal 
        where id=1001538863 

       */
       
       String consulta="select * from personal \n" +
"        where id="+ id ;
       
       try {
           
           ResultSet registro = DB.resultQuery(consulta);
           
           if(registro.next()){
             return true;
           }
           
       } catch (Exception e) {
           System.out.println(e);
       }
   
       return false;
   }
     
   
   /**
    * Metodo que ingresa un registro a la tabla  mision  en la base de datos 
    * @param nombre
    * @param costo
    * @param estadoMision
    * @param objetivoMision
    * @param fechaLanzamiento
    * @param fechaFinalizacion 
    */
   public static void ingresarMision(String nombre,String costo,String estadoMision,String objetivoMision, String fechaLanzamiento,String fechaFinalizacion){
   
    /*
       -insert into misiones(nombre,fechalanzamiento,fechafinalizacion,costemision,estadomision,objetivomision) 
        values('StarLink','2018-02-22',null,'10 billones','En curso','Construccion de una red intercional de internet')
       
       -insert into misiones(nombre,fechalanzamiento,fechafinalizacion,costemision,estadomision,objetivomision) 
        values('Juno','2011-08-05',null,'700 millones','En curso','Medir el ambiente del planeta jupiter')
       
       */       
       
       nombre=consultas.convert(nombre);
       fechaLanzamiento=consultas.convert(fechaLanzamiento);
       fechaFinalizacion=consultas.convert(fechaFinalizacion);
       costo=consultas.convert(costo);
       estadoMision=consultas.convert(estadoMision);
       objetivoMision=consultas.convert(objetivoMision);
       
    
    
     String sentencia="insert into misiones(nombre,fechalanzamiento,fechafinalizacion,costemision,estadomision,objetivomision) \n" +
"        values("+nombre+","+fechaLanzamiento+","+fechaFinalizacion+","+costo+","+estadoMision+","+objetivoMision+")";
      
       try {
           
          DB.insert(sentencia);      
          
       } catch (Exception e) {
           System.out.println(e);
       }
     
   }
   
   
   /**
    * Metodo que ingresa un registro a la tabla personal en la base de datos
    * @param nombre
    * @param fechaNacimiento
    * @param id 
    */
   public static void ingresarPersona(String nombre,String fechaNacimiento, int id){
   
       /*
       insert into personal(nombre,id,fechanacimiento) 
        values('Valentina',1012538863,'1999-04-09')
       */
    
       nombre=consultas.convert(nombre);
       fechaNacimiento=consultas.convert(fechaNacimiento);
       
       
       String sentencia="insert into personal(nombre,id,fechanacimiento) \n" +
"        values("+nombre+","+id+","+fechaNacimiento+")";
          
       
       
       try {
           
          DB.insert(sentencia);      
          
       } catch (Exception e) {
           System.out.println(e);
       }
   
   }
   
   /**
    * Metodo que ingresa un registro a la tabla  personalMision  en la base de datos
    * @param nombre
    * @param fechaNacimiento
    * @param id
    * @param titulo 
    */
   public static void ingresarPersonaMision(String nombre,String fechaNacimiento, int id, String titulo){
   
       /*
       insert into personal(nombre,id,fechanacimiento,titulo) 
        values('kevin',1012538863,'1999-04-09',ing mecanico)
       */
    
       nombre=consultas.convert(nombre);
       fechaNacimiento=consultas.convert(fechaNacimiento);
       titulo=consultas.convert(titulo);
       
       String sentencia="insert into personal(nombre,id,fechanacimiento,titulo) \n" +
"        values("+nombre+","+id+","+fechaNacimiento+","+titulo+")";
       
       try {
           
          DB.insert(sentencia);      
          
       } catch (Exception e) {
           System.out.println(e);
       }
   
   }
   
   /**
    * Metodo que ingresa un registro a la tabla  entidad  en la base de datos
    * @param nombre 
    */
   public static void ingresarEntidad(String nombre){
   
       /*
        insert into entidadafiliada(nombre) 
        values('Blue Origin')  
       */
       
        nombre=consultas.convert(nombre);
        
        String sentencia="insert into entidadafiliada(nombre) \n" +
"        values("+nombre+")";
        
        try {
           
          DB.insert(sentencia);      
          
       } catch (Exception e) {
           System.out.println(e);
       }
   }
   
   /**
    * Metodo que ingresa un registro a la tabla  observaciones en la base de datos
    * @param objeto
    * @param lugar
    * @param hora
    * @param idPersona 
    */
   public static void ingresarObservacion(String objeto,String lugar,String hora, int idPersona){
   
       /*
         insert into observaciones(hora,lugar,objeto) 
        values('2:00 am','sabaneta','Luna')
       
       */
       
       objeto=consultas.convert(objeto);
       lugar=consultas.convert(lugar);
       hora=consultas.convert(hora);
       
       
            String sentencia=" insert into observaciones(hora,lugar,objeto,idpersonal) \n" +
"        values("+hora+","+lugar+","+objeto+","+idPersona+")";
        
        try {
           
          DB.insert(sentencia);      
          
       } catch (Exception e) {
           System.out.println(e);
       }
   }
   
   /**
    * Metodo que ingresa un registro a la tabla  personalMision  en la base de datos
    * @param idMision
    * @param idPersonal 
    */
   public static void ingresarPersonalMision(int idMision,int idPersonal){
      
       /*
          insert into personalmision(idmision,idpersonal) values(4,7)
       
       */
       
       String sentencia="insert into personalmision(idmision,idpersonal) values("+idMision+","+idPersonal+")";
       try {
           
          DB.insert(sentencia);      
          
       } catch (Exception e) {
           System.out.println(e);
       }
   
   }
   
   /**
    * Metodo que ingresa un registro a la tabla entidadMision  en la base de datos
    * @param idMision
    * @param identidad 
    */
   public static void ingresarEntidadMision(int idMision,int identidad){
   
     /*
       insert into entidadesmision(idmision,identidadafiliada) values(4,10)
       
       */       
       
      String sentencia="insert into entidadesmision(idmision,identidadafiliada) values("+idMision+","+identidad+")";
      
       try {
           
          DB.insert(sentencia);      
          
       } catch (Exception e) {
           System.out.println(e);
       }
   
   }
   
   /**
    * Metodo que ingresa un registro a la tabla  tareasentidadafiliada  en la base de datos
    * @param idEntidadMision
    * @param tarea 
    */
   public static void ingresarTareEntidad(int idEntidadMision,String tarea){
     
       /*
          insert into tareasentidadafiliada(identidadesmision,tarea) values(5,'Creaer el modulo de laboratorios')
       */
       
       tarea=consultas.convert(tarea);
       
       String sentencia="insert into tareasentidadafiliada(identidadesmision,tarea) values("+idEntidadMision+","+tarea+")";
   
        try {
           
          DB.insert(sentencia);      
          
       } catch (Exception e) {
           System.out.println(e);
       }
       
   }
   
   /**
    * Metodo que ingresa un registro a la tabla categoriaMision en la base de datos
    * @param idMision
    * @param idCategoria 
    */
   public static void ingresarCategoriaMision(int idMision,int idCategoria){
   
       /*
          insert into categoriamision(idmision,idcategoria) values(4,7)
       */
       
       String sentencia="insert into categoriamision(idmision,idcategoria) values("+idMision+","+idCategoria+")";
   
        try {
           
          DB.insert(sentencia);      
          
       } catch (Exception e) {
           System.out.println(e);
       }
   }
   
 
   public static int idPersona(String nombrePersona){
     /*
       select id 
             from personal where lower(personal.nombre) like lower('mateo Montoya Aristizabal ')
       
       */
     
     nombrePersona=consultas.convert(nombrePersona);
     
     int idPersona=0;
     
     String consulta="select id from personal where lower(personal.nombre) like " + " lower"+"("+nombrePersona+")";
     
     try {
            ResultSet registro = DB.resultQuery(consulta);
           
            while(registro.next()){
                System.out.println("4");
            }
            
       } catch (Exception e) {
            System.out.println(e);
       }
     
    return idPersona;
   } 
   
   
   

   
}
   
   
     
   
   
      
    
   
   
 
    


