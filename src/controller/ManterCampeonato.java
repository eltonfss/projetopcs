package controller;

import java.util.List;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import model.Campeonato;
import model.Carro;
import model.Corrida;
import model.Equipe;
import model.Piloto;
import model.Posicao;
import model.Resultado;

/**
 * @author elton
 */
public class ManterCampeonato {

    private static Campeonato campeonato;
    private static XMLDecoder xmlDecoder;
    private static XMLEncoder xmlEncoder;
    private static final String PATH_BASE_DE_DADOS = "F1.XML";

    /**
     * Instanciar novo campeonato
     */
    private static boolean instanciarNovoCampeonato(){
        campeonato = new Campeonato();
        return true;
    }
    
    /**
     * Instanciar campeonato existente a partir de uma baseDeDados(F1.XML)
     * @param baseDeDados 
     */
    private static boolean instanciarCampeonatoExistente()throws FileNotFoundException{
       try{
           ManterCampeonato m = new ManterCampeonato();
           String path;
           try{
             path = m.getClass().getClassLoader().getResource(PATH_BASE_DE_DADOS).getPath().replace("%20", " ");
           }catch(Exception e){
               path = null;
           }
           if(path != null){
            xmlDecoder = new XMLDecoder(new FileInputStream(path));
            campeonato = (Campeonato) xmlDecoder.readObject();
           }
           if(campeonato != null){
                return true;
           }else{
               return false;
           }
       }finally{
           if(xmlDecoder != null)
            xmlDecoder.close();
       }
    }
       
    /**
     * Persistir campeonato na base de dados
     * @param baseDeDados
     * @return
     * @throws FileNotFoundException 
     */
    private static boolean persistirCampeonato()throws FileNotFoundException{
       try{
            xmlEncoder = new XMLEncoder(new FileOutputStream(PATH_BASE_DE_DADOS));
            xmlEncoder.writeObject(campeonato);
            return true;
        }finally{
            if(xmlEncoder != null)
               xmlEncoder.close();
        } 
    }

    /**
     * verifica se o arquivo de calendário de corridas já foi importado na base de dados
     * @return
     */
    public static boolean calendarioDeCorridasJaFoiImportado(){
        try {
            if(instanciarCampeonatoExistente()){
                if(campeonato.getCorridas().isEmpty()){
                    return false;
                }else{
                    return true;
                }
            }else{
                return false;
            }
        } catch (FileNotFoundException ex) {
            System.err.println("ERRO: " + ex.getMessage());
            return false;
        }
    }
    
    /**
     * Método auxiliar que retorna um List de Corrida de um arquivo de Calendário de Corridas
     * @param arquivoDeEntrada
     * @return
     * @throws Exception
     */
    private static List<Corrida> lerCalendarioDeCorridas(File arquivoDeEntrada) throws Exception{
        
        List<Corrida> corridas = new ArrayList<Corrida>();
        BufferedReader reader = new BufferedReader(new FileReader(arquivoDeEntrada));
        //Lê a primeira linha do arquivo
        String linha = reader.readLine();
        //Variáveis utilizadas dentro do for
        String[] arrayLinha;
        Corrida corrida;
        //Enquanto houverem linhas
        while(linha != null){
            //Quebrar string da linha em um array por ";"
            arrayLinha = linha.split(";");
            //Validar se arquivo está no formato correto
            if(arrayLinha.length == 4){
                //Instanciar uma corrida setando os atributos com os valores lidos na linha
                corrida = new Corrida();
                //Integer.parseInt() -- converter string em inteiro
                corrida.setNumeroDaCorrida(Integer.parseInt(arrayLinha[0]));
                corrida.setNomeDaEtapa(arrayLinha[1]);
                //Date está cortado pois utilizei um método obsoleto porém o mesmo ainda funciona
                corrida.setData(new Date(arrayLinha[2]));
                corrida.setNumeroDeVoltasPrevistas(Integer.parseInt(arrayLinha[3]));
                //Adicionar corrida no list de corridas
                corridas.add(corrida);
            }else{
                throw new Exception("Arquivo de calendário de corridas inválido!");
            }
        }
        return corridas;
    }
     
    /**
     * UC - Importar Calendário de Corridas
     * @param arquivoDeEntrada 
     */
    public static boolean importarCalendarioDeCorridas(File arquivoDeEntrada){
        List<Corrida> corridas;
        File baseDeDados = new File(PATH_BASE_DE_DADOS);
        try{
            if(instanciarCampeonatoExistente()){
                corridas = campeonato.getCorridas();
                
                if(!corridas.isEmpty()){
                    corridas.clear();
                }
                //Popular com dados do arquivoDeEntrada
                corridas.addAll(lerCalendarioDeCorridas(arquivoDeEntrada));
                //Associar list de corridas ao campeonato
                campeonato.setCorridas(corridas);
                persistirCampeonato();
            }else{
                if(instanciarNovoCampeonato()){
                    corridas = new ArrayList<Corrida>();
                    //Popular com dados do arquivoDeEntrada
                    corridas.addAll(lerCalendarioDeCorridas(arquivoDeEntrada));
                    //Associar list de corridas ao campeonato
                    campeonato.setCorridas(corridas);
                    persistirCampeonato();
                }else{
                    throw new Exception("Não foi possível instanciar novo campeonato!");
                }
            }
            return true;
        }catch(Exception e){
            System.err.println("ERRO: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * verifica se o arquivo de pilotos já foi importado na base de dados
     * @return 
     */
    public static boolean pilotosJaForamImportados(){
        try {
            if(instanciarCampeonatoExistente()){
                if(campeonato.getPilotos().isEmpty()){
                    return false;
                }else{
                    return true;
                }
            }else{
                return false;
            }
        } catch (FileNotFoundException ex) {
            System.err.println("ERRO: " + ex.getMessage());
            return false;
        }
    }
    
    /**
     * Método auxiliar que retorna um List de Piloto lido do arquivo de Pilotos e Equipes
     * @param arquivoDeEntrada
     * @return
     * @throws Exception 
     */
    private static List<Piloto> lerPilotos(File arquivoDeEntrada) throws Exception{
        List<Piloto> pilotos = new ArrayList<Piloto>();
        BufferedReader reader = new BufferedReader(new FileReader(arquivoDeEntrada));
        String linha = reader.readLine();
        String[] arrayLinha;
        Carro carro;
        Piloto piloto;
        Equipe equipe;
        while(linha != null){
            arrayLinha = linha.split(";");
            if(arrayLinha.length == 3){
                //Instanciar objetos
                carro = new Carro();
                piloto = new Piloto();
                equipe = new Equipe();
                //Setar atributos com valores lidos na linha
                carro.setNumero(Integer.parseInt(arrayLinha[0]));
                piloto.setNome(arrayLinha[1]);
                equipe.setNome(arrayLinha[2]);
                //Associar objetos
                equipe.setCarro(carro);
                carro.setEquipe(equipe);
                carro.setPiloto(piloto);
                piloto.setCarro(carro);
                //Adicionar piloto no List
                pilotos.add(piloto);
            }else{
                throw new Exception("Arquivo de pilotos e equipes inválido!");
            }
        }
        return pilotos;
    }
    
    /**
     * UC - Importar Pilotos
     * @param arquivoDeEntrada 
     */
    public static boolean importarPilotos(File arquivoDeEntrada){
        List<Piloto> pilotos;
        List<Corrida> corridas;
        File baseDeDados = new File(PATH_BASE_DE_DADOS);
        try {
            if(instanciarCampeonatoExistente()){
                pilotos = campeonato.getPilotos();
                corridas = campeonato.getCorridas();
                if(!pilotos.isEmpty()){
                    //Limpar resultados de corrida
                    if(!corridas.isEmpty()){
                        for (Corrida corrida : corridas) {
                            corrida.setResultado(null);
                        }
                    }
                    //Limpar pilotos
                    pilotos.clear();
                }
                lerPilotos(arquivoDeEntrada);
                campeonato.setPilotos(pilotos);
                persistirCampeonato();
            }else{
                if(instanciarNovoCampeonato()){
                    pilotos = new ArrayList<Piloto>();
                    lerPilotos(arquivoDeEntrada);
                    campeonato.setPilotos(pilotos);
                    persistirCampeonato();
                }else{
                    throw new Exception("Não foi possível instanciar novo campeonato!");
                }
            }
            return true;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Método auxiliar que retorna um Resultado de um arquivo de Resultado de Corrida
     * @param arquivoDeEntrada
     * @return
     * @throws Exception 
     */
    private static Resultado lerResultado(File arquivoDeEntrada) throws Exception{
       Resultado resultado = new Resultado();
       BufferedReader reader = new BufferedReader(new FileReader(arquivoDeEntrada));
       String[] arrayLinha;
       String linha;
       //Ler CORRIDA:<NÚMERO DA CORRIDA>
       Corrida corrida = new Corrida();
       linha = reader.readLine();
       if(linha != null){
        arrayLinha = linha.split(":");
       }else{
           throw new Exception("Arquivo de resultado de corrida inválido!");
       }
       if(arrayLinha.length == 2){
           corrida.setNumeroDaCorrida(Integer.parseInt(arrayLinha[1]));
           resultado.setCorrida(corrida);
           corrida.setResultado(resultado);
       }else{
           throw new Exception("Arquivo de resultado de corrida inválido!");
       }
       //Ler VOLTAR REALIZADAS:<NÚMERO DE VOLTAS>
       linha = reader.readLine();
       if(linha != null){
        arrayLinha = linha.split(":");
       }else{
           throw new Exception("Arquivo de resultado de corrida inválido!");
       }
       if(arrayLinha.length == 2){
           resultado.setNumeroDeVoltasRealizadas(Integer.parseInt(arrayLinha[1]));
       }else{
           throw new Exception("Arquivo de resultado de corrida inválido!");
       }
       //Ler Posições <Número da Posição>;<Número do Carro>
       List<Posicao> posicoes = new ArrayList<Posicao>();
       Posicao posicao;
       Carro carro;
       linha = reader.readLine();
       while(linha != null){
           arrayLinha = linha.split(";");
           if(arrayLinha.length == 2){
               posicao = new Posicao();
               posicao.setNumero(Integer.parseInt(arrayLinha[0]));
               carro = new Carro();
               carro.setNumero(Integer.parseInt(arrayLinha[1]));
               posicao.setCarro(carro);
               posicoes.add(posicao);
           }else{
               throw new Exception("Arquivo de resultado de corrida inválido!");
           }
       }
       resultado.setPosicoes(posicoes);
       return resultado;
    }
    
    /**
     * verifica se o arquivo de resultado da corrida já foi importado na base de dados
     * @param arquivoDeEntrada
     * @return 
     */
    public static boolean resultadoDeCorridaJaFoiImportado(File arquivoDeEntrada){
        try{
            if(calendarioDeCorridasJaFoiImportado()){
                //Obtem list de corridas do campeonato
                List<Corrida> corridas = campeonato.getCorridas();
                //Lê resultado do arquivo
                Resultado resultado = lerResultado(arquivoDeEntrada);
                //Busca corrida do campeonato correspondente ao resultado
                Corrida corridaResultado = resultado.getCorrida();
                for (Corrida corrida : corridas) {
                    if(corrida.getNumeroDaCorrida().equals(corridaResultado.getNumeroDaCorrida())){
                        if(corrida.getResultado() != null){
                            return false;
                        }else{
                            return true;
                        }
                    }
                }
            }else{
                throw new Exception("Calendário de corridas ainda não foi importado!");
            }
            return false;
       }catch(Exception e){
           System.err.println("ERRO: " + e.getMessage());
           return false;
       }
    }
    
    /**
     * UC - Importar Resultado de Corrida
     * @param arquivoDeEntrada 
     */
    public static boolean importarResultadoDeCorrida(File arquivoDeEntrada){
       try{
            if(calendarioDeCorridasJaFoiImportado()){
                //Obtem list de corridas do campeonato
                List<Corrida> corridas = campeonato.getCorridas();
                //Lê resultado do arquivo
                Resultado resultado = lerResultado(arquivoDeEntrada);
                //Busca corrida do campeonato correspondente ao resultado e associa ao resultado
                Corrida corridaResultado = resultado.getCorrida();
                for (Corrida corrida : corridas) {
                    if(corrida.getNumeroDaCorrida().equals(corridaResultado.getNumeroDaCorrida())){
                        corrida.setResultado(resultado);
                    }
                }
                //Associa o List de corridas atualizado ao campeonato
                campeonato.setCorridas(corridas);
                //Salvar
                persistirCampeonato();
            }else{
                throw new Exception("Calendário de corridas ainda não foi importado!");
            }
            return true;
       }catch(Exception e){
           System.err.println("ERRO: " + e.getMessage());
           return false;
       }
    }
   
}
