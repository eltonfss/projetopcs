package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author notle
 */
public class Equipe implements Serializable, Comparable<Equipe>{
    
    private String nome;
    private Carro carro;
    private Integer pontuacao;

    /**
     * Construtor vazio
     */
    public Equipe() {
        nome = "";
        pontuacao = 0;
    }

    /**
     * Construtor parametrizado
     * @param nome
     * @param carro 
     */
    public Equipe(String nome, Carro carro) {
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

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public int compareTo(Equipe o) {
        if(pontuacao > o.getPontuacao()){
            return -1;
        }else if(pontuacao < o.getPontuacao()){
            return 1;
        }else{
            return 0;
        }
    }

}
