package modelo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author elton
 */
public class Corrida implements Serializable{
    
    private Integer numeroDaCorrida;
    private String nomeDaEtapa;
    private Date data;
    private Integer numeroDeVoltasPrevistas;
    private List<Resultado> resultados;

    /**
     * Construtor vazio
     */
    public Corrida() {
        numeroDaCorrida = new Integer(0);
        nomeDaEtapa = new String();
        data = new Date();
        numeroDeVoltasPrevistas = new Integer(0);
        resultados = new ArrayList<Resultado>();
    }

    /**
     * Construtor parametrizado
     * @param numeroDaCorrida
     * @param nomeDaEtapa
     * @param data
     * @param numeroDeVoltasPrevistas
     * @param resultados 
     */
    public Corrida(Integer numeroDaCorrida, String nomeDaEtapa, Date data, Integer numeroDeVoltasPrevistas, List<Resultado> resultados) {
        this.numeroDaCorrida = numeroDaCorrida;
        this.nomeDaEtapa = nomeDaEtapa;
        this.data = data;
        this.numeroDeVoltasPrevistas = numeroDeVoltasPrevistas;
        this.resultados = resultados;
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
    public List<Resultado> getResultados() {
        return resultados;
    }

    /**
     * @param resultados the resultados to set
     */
    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }
    
}
