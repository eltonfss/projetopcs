package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Piloto;

public class ClassificacaoGeralDePilotosTableModel extends AbstractTableModel {  

    private enum columns{
        Posição,
        Nome,
        Equipe,
        Pontuacao,
    }
  
    private List<Piloto> valores;     

    public ClassificacaoGeralDePilotosTableModel() {
        valores = new ArrayList<Piloto>();
    }
    
    public ClassificacaoGeralDePilotosTableModel(List<Piloto> valores) {
        this.valores = valores;
        Collections.sort(valores);
    }
    
    public List<Piloto> getValores() {
        return valores;
    }

    public void setValores(List<Piloto> valores) {
        this.valores = valores;
        Collections.sort(valores);
    }

    public int getRowCount() {  
        return valores.size();  
    }  
  
    public int getColumnCount() {  
        return columns.values().length;  
    }  
    
    public String getColumnName(int columnIndex){
        return columns.values()[columnIndex].toString();
    }
  
    public Object getValueAt(int row, int column) {  
        Piloto piloto = valores.get(row);  
        switch(column){
            case 0:
                return row+1;
            case 1:
                return piloto.getNome();
            case 2:
                return piloto.getCarro().getEquipe().getNome();
            case 3:
                return piloto.getPontuacao();
            default:
                return "";
        }
    }  
  
}  