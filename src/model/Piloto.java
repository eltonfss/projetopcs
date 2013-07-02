package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author elton
 */
public class Piloto implements Serializable{
    
    private String nome;
    private Carro carro;

    /**
     * Construtor vazio
     */
    public Piloto() {
        nome = new String();
        carro = new Carro();
    }

    /**
     * Construtor parametrizado
     * @param nome
     * @param carro 
     */
    public Piloto(String nome, Carro carro) {
        this.nome = nome;
        this.carro = carro;
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the carro
     */
    public Carro getCarro() {
        return carro;
    }

    /**
     * @param carro the carro to set
     */
    public void setCarro(Carro carro) {
        this.carro = carro;
    }
    
}
