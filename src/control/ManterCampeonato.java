package controle;

import java.util.List;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import modelo.Campeonato;
import modelo.Corrida;
import modelo.Piloto;

/**
 * @author elton
 */
public class ManterCampeonato {

    private static Campeonato campeonato;
    private static XMLDecoder xmlDecoder;
    private static XMLEncoder xmlEncoder;
    private static final String PATH_BASE_DE_DADOS = "../F1.XML";

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
    private static boolean instanciarCampeonatoExistente(File baseDeDados)throws FileNotFoundException{
       try{
           xmlDecoder = new XMLDecoder(new FileInputStream(baseDeDados));
           campeonato = (Campeonato) xmlDecoder.readObject();
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
    private static boolean persistirCampeonato(File baseDeDados)throws FileNotFoundException{
       try{
            xmlEncoder = new XMLEncoder(new FileOutputStream(baseDeDados));
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
            if(instanciarCampeonatoExistente(new File(PATH_BASE_DE_DADOS))){
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
     * UC - Importar Calendário de Corridas
     * @param arquivoDeEntrada 
     */
    public static boolean importarCalendarioDeCorridas(File arquivoDeEntrada){
        List<Corrida> corridas;
        File baseDeDados = new File(PATH_BASE_DE_DADOS);
        try{
            if(instanciarCampeonatoExistente(baseDeDados)){
                corridas = campeonato.getCorridas();
                if(!corridas.isEmpty()){
                    corridas.clear();
                }
                //TODO Popular com dados do arquivoDeEntrada
                campeonato.setCorridas(corridas);
                persistirCampeonato(baseDeDados);
            }else{
                if(instanciarNovoCampeonato()){
                    corridas = new ArrayList<Corrida>();
                    //TODO Popular com dados do arquivoDeEntrada
                    campeonato.setCorridas(corridas);
                    persistirCampeonato(baseDeDados);
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
            if(instanciarCampeonatoExistente(new File(PATH_BASE_DE_DADOS))){
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
     * UC - Importar Pilotos
     * @param arquivoDeEntrada 
     */
    public static boolean importarPilotos(File arquivoDeEntrada){
        List<Piloto> pilotos;
        File baseDeDados = new File(PATH_BASE_DE_DADOS);
        try {
            if(instanciarCampeonatoExistente(new File(PATH_BASE_DE_DADOS))){
                pilotos = campeonato.getPilotos();
                if(!pilotos.isEmpty()){
                    pilotos.clear();
                }
                //TODO Popular list com arquivosDeEntrada
                campeonato.setPilotos(pilotos);
                persistirCampeonato(baseDeDados);
            }else{
                if(instanciarNovoCampeonato()){
                    pilotos = new ArrayList<Piloto>();
                    //TODO Popular list com arquivosDeEntrada
                    campeonato.setPilotos(pilotos);
                    persistirCampeonato(baseDeDados);
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
     * UC - Importar Resultado de Corrida
     * @param arquivoDeEntrada 
     */
    public static boolean importarResultadoDeCorrida(File arquivoDeEntrada){
       try{
            if(calendarioDeCorridasJaFoiImportado()){
                //TODO verificar se resultado da corrida já foi importado
                //TODO se não, importar resultado e salvar na base de dados
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
