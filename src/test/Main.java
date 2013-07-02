package teste;

import model.Piloto;
import model.Campeonato;
import model.Equipe;
import model.Corrida;
import model.Carro;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author notle
 */
public class Main {
    
    
    public static void main(String[] args) {
        
        //Criar e associar pilotos,carro e equipe
        Piloto piloto = new Piloto();
        Equipe equipe = new Equipe();
        Carro carro = new Carro();
        
        equipe.setNome("Ferrari");
        equipe.setCarro(carro);

        piloto.setNome("Felipe Massa");
        piloto.setCarro(carro);

        carro.setNumero(1);
        carro.setEquipe(equipe);
        carro.setPiloto(piloto);
        
        //Adicionar piloto no list
        List<Piloto> pilotos = new ArrayList<Piloto>();
        pilotos.add(piloto);
        
        //Criar corrida
        Corrida corrida = new Corrida();
        corrida.setNumeroDaCorrida(1);
        corrida.setNomeDaEtapa("GP INTERLAGOS");
        corrida.setData(new Date(26052013));
        corrida.setNumeroDeVoltasPrevistas(20);
        
        //Adicionar corrida no list
        List<Corrida> corridas = new ArrayList<Corrida>();
        corridas.add(corrida);

        //Criar campionato e associar pilotos e corridas
        Campeonato campeonato = new Campeonato();
        campeonato.setCorridas(corridas);
        campeonato.setPilotos(pilotos);

    }
}