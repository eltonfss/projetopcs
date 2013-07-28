package model;

import java.io.*;

public class Carro implements Serializable{
    
    private Integer numero;
    private Piloto piloto;
    private Equipe equipe;

    public Carro() {
    }
    
    public Carro(Integer numero, Piloto piloto, Equipe equipe) {
        this.numero = numero;
        this.piloto = null;
        this.equipe = null;
    }
    
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
    
}
