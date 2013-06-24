package modelo;

import java.util.*;
import java.io.*;

/**
 * @author elton
 */
public class Campeonato implements Serializable{

    private List<Corrida> corridas;
    private List<Piloto> pilotos;
      
    /**
     * Construtor vazio
     */
    public Campeonato() {
        corridas = new ArrayList<Corrida>();
        pilotos = new ArrayList<Piloto>();
    }

    /**
     * Construtor parametrizado
     * @param corridas
     * @param pilotos 
     */
    public Campeonato(List<Corrida> corridas, List<Piloto> pilotos) {
        this.corridas = corridas;
        this.pilotos = pilotos;
    }
    
    /**
     * @return the corridas
     */
    public List<Corrida> getCorridas() {
        return corridas;
    }

    /**
     * @param corridas the corridas to set
     */
    public void setCorridas(List<Corrida> corridas) {
        this.corridas = corridas;
    }

    /**
     * @return the pilotos
     */
    public List<Piloto> getPilotos() {
        return pilotos;
    }

    /**
     * @param pilotos the pilotos to set
     */
    public void setPilotos(List<Piloto> pilotos) {
        this.pilotos = pilotos;
    }

}
