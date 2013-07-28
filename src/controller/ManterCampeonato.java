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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javax.swing.JTable;
import model.Campeonato;
import model.Carro;
import model.Corrida;
import model.Equipe;
import model.Piloto;
import model.Posicao;
import model.Resultado;
import view.ClassificacaoDePilotosPorCorridaTableModel;
import view.ClassificacaoGeralDePilotosTableModel;
import view.ClassificacaoGeralDeEquipesTableModel;
import view.CorridasComboBoxModel;

public class ManterCampeonato {

    private static Campeonato campeonato;
    private static XMLDecoder xmlDecoder;
    private static XMLEncoder xmlEncoder;
    private static final String PATH_BASE_DE_DADOS = "src/F1.XML";

    private static boolean instanciarNovoCampeonato(){
        campeonato = new Campeonato();
        return true;
    }
    
    private static boolean instanciarCampeonatoExistente(){
       try{
           xmlDecoder = new XMLDecoder(new FileInputStream(PATH_BASE_DE_DADOS));
           campeonato = (Campeonato) xmlDecoder.readObject();
           if(campeonato != null){
                return true;
           }else{
               return false;
           }
       }catch(FileNotFoundException e){
           return false;
       }finally{
           if(xmlDecoder != null)
            xmlDecoder.close();
       }
    }
       
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

    public static boolean calendarioDeCorridasJaFoiImportado(){
        if(instanciarCampeonatoExistente()){
            if(campeonato.getCorridas().isEmpty()){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
    
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
                corrida.setNumeroDaCorrida(Integer.parseInt(arrayLinha[0].trim()));
                corrida.setNomeDaEtapa(arrayLinha[1]);
                //Date está cortado pois utilizei um método obsoleto porém o mesmo ainda funciona
                corrida.setData(new Date(arrayLinha[2].trim()));
                corrida.setNumeroDeVoltasPrevistas(Integer.parseInt(arrayLinha[3].trim()));
                //Adicionar corrida no list de corridas
                corridas.add(corrida);
            }else{
                throw new Exception("Arquivo de calendário de corridas inválido!");
            }
            //Ler próxima linha
            linha = reader.readLine();
        }
        return corridas;
    }
     
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
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * verifica se o arquivo de pilotos já foi importado na base de dados
     * @return 
     */
    public static boolean equipesJaForamImportadas(){
        if(instanciarCampeonatoExistente()){
            if(campeonato.getEquipes().isEmpty()){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
    
    /**
     * Método auxiliar que retorna um List de Piloto lido do arquivo de Pilotos e Equipes
     * @param arquivoDeEntrada
     * @return
     * @throws Exception 
     */
    private static List<Equipe> lerEquipes(File arquivoDeEntrada) throws Exception{
        List<Equipe> equipes = new ArrayList<Equipe>();
        BufferedReader reader = new BufferedReader(new FileReader(arquivoDeEntrada));
        String linha = reader.readLine();
        String[] arrayLinha;
        Carro carro;
        Piloto piloto;
        Equipe equipe;
        while(linha != null){
            arrayLinha = linha.split(";");
            if(arrayLinha.length == 3){
                carro = new Carro();
                piloto = new Piloto();
                equipe = new Equipe();
                setarAtributosComValoresLidosNaLinha(carro, arrayLinha, piloto, equipe);
                if(!equipeJaFoiImportada(equipes, equipe, carro, piloto)){
                    importarNovaEquipe(equipe, carro, piloto, equipes);
                }
            }else{
                throw new Exception("Arquivo de pilotos e equipes inválido!");
            }
            linha = reader.readLine();
        }
        return equipes;
    }
    
    /**
     * UC - Importar Pilotos
     * @param arquivoDeEntrada 
     */
    public static boolean importarEquipes(File arquivoDeEntrada){
        List<Equipe> equipes;
        List<Corrida> corridas;
        File baseDeDados = new File(PATH_BASE_DE_DADOS);
        try {
            if(instanciarCampeonatoExistente()){
                importarEquipesEmCampeonadoExistente(arquivoDeEntrada);
            }else{
                if(instanciarNovoCampeonato()){
                    importarEquipesEmNovoCampeonato(arquivoDeEntrada);
                }else{
                    throw new Exception("Não foi possível instanciar novo campeonato!");
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    private static Resultado lerResultado(File arquivoDeEntrada) throws Exception{
       Resultado resultado = new Resultado();
       BufferedReader reader = new BufferedReader(new FileReader(arquivoDeEntrada));
       String[] arrayLinha = null;
       String linha = null;
       arrayLinha = lerCorrida(reader, arrayLinha, resultado);
       lerVoltarRealizadas(reader, arrayLinha, resultado);
       lerPosicoes(linha, reader, resultado);
       return resultado;
    }
    
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
                            return true;
                        }else{
                            return false;
                        }
                    }
                }
            }else{
                throw new Exception("Calendário de corridas ainda não foi importado!");
            }
            return false;
       }catch(Exception e){
           e.printStackTrace();
           return false;
       }
    }
    
    /**
     * verifica se algum arquivo de resultado da corrida já foi importado na base de dados
     * @return 
     */
    public static boolean resultadoDeCorridaJaFoiImportado(){
        try{
            if(calendarioDeCorridasJaFoiImportado()){
                //Obtem list de corridas do campeonato
                List<Corrida> corridas = campeonato.getCorridas();
                //Verifica se existe algum resultado instanciado
                for (Corrida corrida : corridas) {
                    if(corrida.getResultado() != null){
                        return true;
                    }
                }
            }
            return false;
       }catch(Exception e){
           e.printStackTrace();
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
           e.printStackTrace();
           return false;
       }
    }
   
    public static CorridasComboBoxModel getCorridasComboBoxModel(){
        return new CorridasComboBoxModel(getNumerosDeCorridasComResultado());
    }
    
    public static ClassificacaoGeralDePilotosTableModel getClassificacaoGeralDePilotosTableModel(){
        return new ClassificacaoGeralDePilotosTableModel(pontuarPilotos());
    }
    
    public static ClassificacaoGeralDeEquipesTableModel getClassificacaoGeralDeEquipesTableModel(){
        return new ClassificacaoGeralDeEquipesTableModel(pontuarEquipes());
    }

    public static ClassificacaoDePilotosPorCorridaTableModel getClassificacaoDePilotosPorCorridaTableModel(Integer numeroDaCorrida) {
        return new ClassificacaoDePilotosPorCorridaTableModel(pontuarPilotos(numeroDaCorrida));
    }
    
    private static List<Equipe> pontuarEquipes(){
        List<Equipe> equipes = setColocacoesEmEquipes();
        pontuarEquipes(equipes);
        return equipes;
    }
    
    private static List<Piloto> pontuarPilotos(){
        Resultado resultado = null;
        List<Piloto> valores = new ArrayList<Piloto>();
        if(resultadoDeCorridaJaFoiImportado()){
            getPilotos(valores);
            for(Corrida corrida : campeonato.getCorridas()){
                resultado = corrida.getResultado();
                if(resultado !=  null){
                    if(resultado.getNumeroDeVoltasRealizadas() > 1){
                        if(resultado.getNumeroDeVoltasRealizadas() >= corrida.getNumeroDeVoltasPrevistas()*0.75){
                            for (Posicao posicao : resultado.getPosicoes()) {
                                Double[] pontuacao = {25.0,18.0,15.0,12.0,10.0,8.0,6.0,4.0,2.0,1.0};
                                pontuarPiloto(valores, posicao,pontuacao);
                            }
                        }else{
                            for (Posicao posicao : resultado.getPosicoes()) {
                                Double[] pontuacao = {12.5,9.0,7.5,6.0,5.0,4.0,3.0,2.0,1.0,0.5};
                                pontuarPiloto(valores, posicao,pontuacao);
                            }
                        }
                    }
                }
            }
        }
        return valores;
    }
    
    private static List<Piloto> pontuarPilotos(Integer numeroDaCorrida) {
        Resultado resultado = null;
        List<Piloto> valores = new ArrayList<Piloto>();
        if(resultadoDeCorridaJaFoiImportado()){
            getPilotos(valores);
            resultado = getResultado(numeroDaCorrida, resultado);
        }
        if(resultado !=  null){
            if(resultado.getNumeroDeVoltasRealizadas() > 1){
                if(resultado.getNumeroDeVoltasRealizadas() > resultado.getCorrida().getNumeroDeVoltasPrevistas()*0.75){
                    valores = pontuarPilotosNormal(resultado, valores);
                }else{
                    valores = pontuarPilotosPelaMetade(resultado, valores);
                }
            }
        }
        return valores;
    }
    
    private static List<Integer> getNumerosDeCorridasComResultado(){
        List<Integer> numerosDeCorridasComResultados = new ArrayList<Integer>();
        if(instanciarCampeonatoExistente()){
            for (Corrida corrida : campeonato.getCorridas()) {
                if(corrida.getResultado() != null){
                    numerosDeCorridasComResultados.add(corrida.getNumeroDaCorrida());
                }
            }
        }
        return numerosDeCorridasComResultados;
    }

    private static List<Piloto> pontuarPiloto(List<Piloto> valores, Posicao posicao,Double[] pontuacao) {
        for (Piloto piloto : valores) {
            if(piloto.getCarro().getNumero().equals(posicao.getCarro().getNumero())){
                piloto.setPontuacao(piloto.getPontuacao()+pontuacao[posicao.getNumero()-1]);
            }
        }
        return valores;
    }

    private static boolean equipeJaFoiImportada(List<Equipe> equipes, Equipe equipe, Carro carro, Piloto piloto) throws Exception {
        //Se equipe já foi importada associar carro a equipe
        for(Equipe e : equipes){
            if(e.getNome().equals(equipe.getNome())){
                if(e.getCarro2() == null){
                    e.setCarro2(carro);
                    carro.setEquipe(e);
                    carro.setPiloto(piloto);
                    piloto.setCarro(carro);
                    return true;
                }else{
                    throw new Exception("Não é possível associar mais de dois carros a uma mesma equipe!");
                }
            }
        }
        return false;
    }

    private static void setarAtributosComValoresLidosNaLinha(Carro carro, String[] arrayLinha, Piloto piloto, Equipe equipe) throws NumberFormatException {
        //Setar atributos com valores lidos na linha
        carro.setNumero(Integer.parseInt(arrayLinha[0]));
        piloto.setNome(arrayLinha[1]);
        equipe.setNome(arrayLinha[2]);
    }

    private static void importarNovaEquipe(Equipe equipe, Carro carro, Piloto piloto, List<Equipe> equipes) {
        equipe.setCarro1(carro);
        carro.setEquipe(equipe);
        carro.setPiloto(piloto);
        piloto.setCarro(carro);
        equipes.add(equipe);
    }

    private static void limparResultadosDeCorrida(List<Corrida> corridas) {
        if(!corridas.isEmpty()){
            for (Corrida corrida : corridas) {
                corrida.setResultado(null);
            }
        }
    }

    private static void importarEquipesEmCampeonadoExistente(File arquivoDeEntrada) throws FileNotFoundException, Exception {
        List<Equipe> equipes;
        List<Corrida> corridas;
        equipes = campeonato.getEquipes();
        corridas = campeonato.getCorridas();
        if(!equipes.isEmpty()){
            limparResultadosDeCorrida(corridas);
            equipes.clear();
        }
        equipes = lerEquipes(arquivoDeEntrada);
        campeonato.setEquipes(equipes);
        persistirCampeonato();
    }

    private static void importarEquipesEmNovoCampeonato(File arquivoDeEntrada) throws FileNotFoundException, Exception {
        List<Equipe> equipes;
        equipes = lerEquipes(arquivoDeEntrada);
        campeonato.setEquipes(equipes);
        persistirCampeonato();
    }

    private static void getPilotos(List<Piloto> valores) {
        for (Equipe equipe : campeonato.getEquipes()) {
            if(equipe.getCarro1() != null){
                valores.add(equipe.getCarro1().getPiloto());
            }
            if(equipe.getCarro2() != null){
                valores.add(equipe.getCarro2().getPiloto());
            }
        }
    }

    private static Resultado getResultado(Integer numeroDaCorrida, Resultado resultado) {
        for(Corrida corrida : campeonato.getCorridas()){
            if(corrida.getNumeroDaCorrida().equals(numeroDaCorrida)){
                resultado = corrida.getResultado();
                resultado.setCorrida(corrida);
            }
        }
        return resultado;
    }

    private static List<Piloto> pontuarPilotosNormal(Resultado resultado, List<Piloto> valores) {
        for (Posicao posicao : resultado.getPosicoes()) {
            Double[] pontuacao = {25.0,18.0,15.0,12.0,10.0,8.0,6.0,4.0,2.0,1.0};
            valores = pontuarPiloto(valores, posicao,pontuacao);
        }
        return valores;
    }

    private static List<Piloto> pontuarPilotosPelaMetade(Resultado resultado, List<Piloto> valores) {
        for (Posicao posicao : resultado.getPosicoes()) {
            Double[] pontuacao = {12.5,9.0,7.5,6.0,5.0,4.0,3.0,2.0,1.0,0.5};
            valores = pontuarPiloto(valores, posicao,pontuacao);
        }
        return valores;
    }

    private static String[] lerCorrida(BufferedReader reader, String[] arrayLinha, Resultado resultado) throws IOException, Exception {
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
            corrida.setNumeroDaCorrida(Integer.parseInt(arrayLinha[1].trim()));
            resultado.setCorrida(corrida);
            corrida.setResultado(resultado);
        }else{
            throw new Exception("Arquivo de resultado de corrida inválido!");
        }
        return arrayLinha;
    }

    private static void lerVoltarRealizadas(BufferedReader reader, String[] arrayLinha, Resultado resultado) throws Exception, IOException {
        String linha;
        //Ler VOLTAR REALIZADAS:<NÚMERO DE VOLTAS>
        linha = reader.readLine();
        if(linha != null){
         arrayLinha = linha.split(":");
        }else{
            throw new Exception("Arquivo de resultado de corrida inválido!");
        }
        if(arrayLinha.length == 2){
            resultado.setNumeroDeVoltasRealizadas(Integer.parseInt(arrayLinha[1].trim()));
        }else{
            throw new Exception("Arquivo de resultado de corrida inválido!");
        }
    }

    private static void lerPosicoes(String linha, BufferedReader reader, Resultado resultado) throws IOException, Exception {
        String[] arrayLinha;
        //Ler Posições <Número da Posição>;<Número do Carro>
        List<Posicao> posicoes = new ArrayList<Posicao>();
        Posicao posicao;
        Carro carro;
        linha = reader.readLine();
        while(linha != null){
            arrayLinha = linha.split(";");
            if(arrayLinha.length == 2){
                posicao = new Posicao();
                posicao.setNumero(Integer.parseInt(arrayLinha[0].trim()));
                carro = new Carro();
                carro.setNumero(Integer.parseInt(arrayLinha[1].trim()));
                posicao.setCarro(carro);
                posicoes.add(posicao);
            }else{
                throw new Exception("Arquivo de resultado de corrida inválido!");
            }
            //Ler próxima linha
            linha = reader.readLine();
        }
        resultado.setPosicoes(posicoes);
    }

    private static void adicionarColocacaoDoPilotoNaEquipe(Equipe equipe, List<Piloto> pilotos, Piloto piloto) {
        List<Integer> colocacoes;
        colocacoes = equipe.getColocacoes();
        Integer colocacaoPiloto = pilotos.indexOf(piloto)+1;
        while(colocacoes.size() < colocacaoPiloto){
                colocacoes.add(0);
        }
        colocacoes.set(colocacaoPiloto-1, colocacoes.get(colocacaoPiloto-1)+1);
    }

    private static boolean pilotoPertenceAEquipe(Piloto piloto, Equipe equipe) {
        return piloto.getCarro().getEquipe().getNome().equals(equipe.getNome());
    }

    private static Corrida getCorrida(Integer numeroDaCorrida) {
        for (Corrida c : campeonato.getCorridas()) {
            if(c.getNumeroDaCorrida().equals(numeroDaCorrida)){
                return c;
            }
        }
        return null;
    }

    private static List<Equipe> setColocacoesEmEquipes() {
        List<Integer> numerosDeCorridasComResultado = getNumerosDeCorridasComResultado();
        List<Piloto> pilotos = new ArrayList<Piloto>();
        List<Equipe> equipes = campeonato.getEquipes();
        for (Integer numeroDaCorrida : numerosDeCorridasComResultado) {
            pilotos = pontuarPilotos(numeroDaCorrida);
            Collections.sort(pilotos);
            Corrida corrida = getCorrida(numeroDaCorrida);
            for (Piloto piloto : pilotos) {
                for (Equipe equipe : equipes) {
                    if(pilotoPertenceAEquipe(piloto, equipe)){
                        if(corrida.getResultado().getNumeroDeVoltasRealizadas() > 1){
                            adicionarColocacaoDoPilotoNaEquipe(equipe, pilotos, piloto);
                        }
                    }
                }
            }
        }
        return equipes;
    }

    private static void pontuarEquipes(List<Equipe> equipes) {
        List<Piloto> pilotos = pontuarPilotos();
        for (Equipe equipe : equipes) {
            for (Piloto piloto : pilotos) {
                if(piloto.getCarro().getEquipe().getNome().equals(equipe.getNome())){
                    equipe.setPontuacao(equipe.getPontuacao()+piloto.getPontuacao());
                }
            }
        }
    }

}
