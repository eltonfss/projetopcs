package model;

import java.io.Serializable;

public class Piloto implements Serializable, Comparable<Piloto>{
    
    private String nome;
    private Carro carro;
    private Double pontuacao;

    public Piloto() {
        nome = "";
        pontuacao = 0.0;
    }

    public Piloto(String nome, Carro carro,Double pontuacao) {
        this.nome = nome;
        this.carro = carro;
        this.pontuacao = pontuacao;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Double getPontuacao() {
        return pontuacao;
    }

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
