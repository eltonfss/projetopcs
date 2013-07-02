package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author elton
 */
public class Posicao implements Serializable{

    private Integer numero;
    private Resultado resultado;
    private Carro carro;

    /**
     * Construtor vazio
     */
    public Posicao() {
        numero = new Integer(0);
        resultado = new Resultado();
        carro = new Carro();
    }

    /**
     * Construtor parametrizado
     * @param numero
     * @param resultado
     * @param carro 
     */
    public Posicao(Integer numero, Resultado resultado, Carro carro) {
        this.numero = numero;
        this.resultado = resultado;
        this.carro = carro;
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
     * @return the resultado
     */
    public Resultado getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
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
