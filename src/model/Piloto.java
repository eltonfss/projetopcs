package model;

import java.io.Serializable;

/**
 * @author elton
 */
public class Piloto implements Serializable, Comparable<Piloto>{
    
    private String nome;
    private Carro carro;
    private Double pontuacao;

    /**
     * Construtor vazio
     */
    public Piloto() {
        nome = "";
        pontuacao = 0.0;
    }

    /**
     * Construtor parametrizado
     * @param nome
     * @param carro 
     * @param pontuacao
     */
    public Piloto(String nome, Carro carro,Double pontuacao) {
        this.nome = nome;
        this.carro = carro;
        this.pontuacao = pontuacao;
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

    /**
     * @return the pontuacao
     */
    public Double getPontuacao() {
        return pontuacao;
    }

    /**
     * @param pontuacao the pontuacao to set
     */
    public void setPontuacao(Double pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public int compareTo(Piloto o) {
        if(pontuacao > o.getPontuacao()){
            return -1;
        }else if(pontuacao < o.getPontuacao()){
            return 1;
        }else{
            return 0;
        }
    }
    
}
