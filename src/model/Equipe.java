package model;

import java.awt.geom.Arc2D;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author notle
 */
public class Equipe implements Serializable, Comparable<Equipe>{
    
    private String nome;
    private Carro carro1;
    private Carro carro2;
    private Double pontuacao;
    private List<Integer> numeroDeColocacoesPorPosicao;

    public Equipe() {
        nome = "";
        pontuacao = 0.0;
        numeroDeColocacoesPorPosicao = new ArrayList<Integer>();
    }
    
    public Equipe(String nome, Carro carro1, Carro carro2) {
        this.nome = nome;
        this.carro1 = carro1;
        this.carro2 = carro2;
    }

    public List<Integer> getColocacoes() {
        return numeroDeColocacoesPorPosicao;
    }

    public void setColocacoes(List<Integer> colocacoes) {
        this.numeroDeColocacoesPorPosicao = colocacoes;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Carro getCarro1() {
        return carro1;
    }

    public void setCarro1(Carro carro1) {
        this.carro1 = carro1;
    }

    public Carro getCarro2() {
        return carro2;
    }

    public void setCarro2(Carro carro2) {
        this.carro2 = carro2;
    }

    public Double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Double pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public int compareTo(Equipe o) {
        if(pontuacao > o.getPontuacao()){
            return -1;
        }else if(pontuacao < o.getPontuacao()){
            return 1;
        }else{
            Integer posicao = 1;
            while(posicao <= numeroDeColocacoesPorPosicao.size() && posicao <=o.getColocacoes().size()){
                if(numeroDeColocacoesPorPosicao.get(posicao-1) > o.getColocacoes().get(posicao-1)){
                    return -1;
                }else if(numeroDeColocacoesPorPosicao.get(posicao-1) < o.getColocacoes().get(posicao-1)){
                    return 1;
                }else{
                    posicao++;
                }
            }
            if(numeroDeColocacoesPorPosicao.size() < o.getColocacoes().size()){
                return 1;
            }else if(numeroDeColocacoesPorPosicao.size() > o.getColocacoes().size()){
                return -1;
            }else{
                return 0;
            }
        }
    }

}
