package model;

import java.util.*;
import java.io.*;

/**
 * @author elton
 */
public class Campeonato implements Serializable{

    private List<Corrida> corridas;
    private List<Equipe> equipes;
      
    public Campeonato() {
        corridas = new ArrayList<Corrida>();
        equipes = new ArrayList<Equipe>();
    }

    public Campeonato(List<Corrida> corridas, List<Equipe> equipes) {
        this.corridas = corridas;
        this.equipes = equipes;
    }
    
    public List<Corrida> getCorridas() {
        return corridas;
    }

    public void setCorridas(List<Corrida> corridas) {
        this.corridas = corridas;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }

}
