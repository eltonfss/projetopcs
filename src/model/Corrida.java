package model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author elton
 */
public class Corrida implements Serializable{
    
    private Integer numeroDaCorrida;
    private String nomeDaEtapa;
    private Date data;
    private Integer numeroDeVoltasPrevistas;
    private Resultado resultado;

    /**
     * Construtor vazio
     */
    public Corrida() {
        numeroDaCorrida = 0;
        nomeDaEtapa = "";
        data = new Date();
        numeroDeVoltasPrevistas = 0;
    }

    /**
     * Construtor parametrizado
     * @param numeroDaCorrida
     * @param nomeDaEtapa
     * @param data
     * @param numeroDeVoltasPrevistas
     * @param resultados 
     */
    public Corrida(Integer numeroDaCorrida, String nomeDaEtapa, Date data, Integer numeroDeVoltasPrevistas, Resultado resultado) {
        this.numeroDaCorrida = numeroDaCorrida;
        this.nomeDaEtapa = nomeDaEtapa;
        this.data = data;
        this.numeroDeVoltasPrevistas = numeroDeVoltasPrevistas;
        this.resultado = resultado;
    }

    /**
     * @return the numeroDaCorrida
     */
    public Integer getNumeroDaCorrida() {
        return numeroDaCorrida;
    }

    /**
     * @param numeroDaCorrida the numeroDaCorrida to set
     */
    public void setNumeroDaCorrida(Integer numeroDaCorrida) {
        this.numeroDaCorrida = numeroDaCorrida;
    }

    /**
     * @return the nomeDaEtapa
     */
    public String getNomeDaEtapa() {
        return nomeDaEtapa;
    }

    /**
     * @param nomeDaEtapa the nomeDaEtapa to set
     */
    public void setNomeDaEtapa(String nomeDaEtapa) {
        this.nomeDaEtapa = nomeDaEtapa;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the numeroDeVoltasPrevistas
     */
    public Integer getNumeroDeVoltasPrevistas() {
        return numeroDeVoltasPrevistas;
    }

    /**
     * @param numeroDeVoltasPrevistas the numeroDeVoltasPrevistas to set
     */
    public void setNumeroDeVoltasPrevistas(Integer numeroDeVoltasPrevistas) {
        this.numeroDeVoltasPrevistas = numeroDeVoltasPrevistas;
    }

    /**
     * @return the resultados
     */
    public Resultado getResultado() {
        return resultado;
    }

    /**
     * @param resultados the resultados to set
     */
    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }
    
}
