package model;

import java.io.*;

/**
 * @author elton
 */
public class Carro implements Serializable{
    
    private Integer numero;
    private Piloto piloto;
    private Equipe equipe;

    /**
     * Construtor vazio
     */
    public Carro() {
        numero = new Integer(0);
    }
    
    /**
     * Construtor parametrizado
     * @param numero
     * @param piloto
     * @param equipe 
     */
    public Carro(Integer numero, Piloto piloto, Equipe equipe) {
        this.numero = numero;
        this.piloto = null;
        this.equipe = null;
    }
    
    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * @return the piloto
     */
    public Piloto getPiloto() {
        return piloto;
    }

    /**
     * @param piloto the piloto to set
     */
    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    /**
     * @return the equipe
     */
    public Equipe getEquipe() {
        return equipe;
    }

    /**
     * @param equipe the equipe to set
     */
    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
    
}
