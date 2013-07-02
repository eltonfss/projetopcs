package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author elton
 */
public class Resultado implements Serializable{
    
    private Integer numeroDeVoltasRealizadas;
    private List<Posicao> posicoes;
    private Corrida corrida;

    /**
     * Construtor vazio
     */
    public Resultado() {
        numeroDeVoltasRealizadas = new Integer(0);
        posicoes = new ArrayList<Posicao>();
        corrida = new Corrida();
    }

    /**
     * Construtor parametrizado
     * @param numeroDeVoltasRealizadas
     * @param posicoes 
     */
    public Resultado(Integer numeroDeVoltasRealizadas, List<Posicao> posicoes,Corrida corrida) {
        this.numeroDeVoltasRealizadas = numeroDeVoltasRealizadas;
        this.posicoes = posicoes;
        this.corrida = corrida;
    }

    /**
     * @return the numeroDeVoltasRealizadas
     */
    public Integer getNumeroDeVoltasRealizadas() {
        return numeroDeVoltasRealizadas;
    }

    /**
     * @param numeroDeVoltasRealizadas the numeroDeVoltasRealizadas to set
     */
    public void setNumeroDeVoltasRealizadas(Integer numeroDeVoltasRealizadas) {
        this.numeroDeVoltasRealizadas = numeroDeVoltasRealizadas;
    }

    /**
     * @return the posicoes
     */
    public List<Posicao> getPosicoes() {
        return posicoes;
    }

    /**
     * @param posicoes the posicoes to set
     */
    public void setPosicoes(List<Posicao> posicoes) {
        this.posicoes = posicoes;
    }

    /**
     * @return the corrida
     */
    public Corrida getCorrida() {
        return corrida;
    }

    /**
     * @param corrida the corrida to set
     */
    public void setCorrida(Corrida corrida) {
        this.corrida = corrida;
    }
    
}
