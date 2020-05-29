/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;
import java.util.Date;
/**
 *
 * @author MateoMA
 */
public class Mision {

    public Mision(String Nombre, String Coste, String EstadoMision, String ObjetivoMision, Date FechaLanzamiento, Date FechaFinalizacion) {
        this.Nombre = Nombre;
        this.Coste = Coste;
        this.EstadoMision = EstadoMision;
        this.ObjetivoMision = ObjetivoMision;
        this.FechaLanzamiento = FechaLanzamiento;
        this.FechaFinalizacion = FechaFinalizacion;
    }
    
    private final String Nombre;
    private final String Coste;
    private final String EstadoMision;
    private final String ObjetivoMision;
    private final Date FechaLanzamiento;
    private final Date FechaFinalizacion;

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @return the Coste
     */
    public String getCoste() {
        return Coste;
    }

    /**
     * @return the EstadoMision
     */
    public String getEstadoMision() {
        return EstadoMision;
    }

    /**
     * @return the ObjetivoMision
     */
    public String getObjetivoMision() {
        return ObjetivoMision;
    }

    /**
     * @return the FechaLanzamiento
     */
    public Date getFechaLanzamiento() {
        return FechaLanzamiento;
    }

    /**
     * @return the FechaFinalizacion
     */
    public Date getFechaFinalizacion() {
        return FechaFinalizacion;
    }
    
    
    
}
