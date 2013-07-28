package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Equipe;

public class ClassificacaoGeralDeEquipesTableModel extends AbstractTableModel{

    private enum columns{
        Posição,
        Nome,
        Pontuacao,
    }
  
    private List<Equipe> valores;     

    public ClassificacaoGeralDeEquipesTableModel() {
        valores = new ArrayList<Equipe>();
    }
    
    public ClassificacaoGeralDeEquipesTableModel(List<Equipe> valores) {
        this.valores = valores;
        Collections.sort(valores);
    }
    
    public List<Equipe> getValores() {
        return valores;
    }

    public void setValores(List<Equipe> valores) {
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
        Equipe equipe = valores.get(row);  
        switch(column){
            case 0:
                return row+1;
            case 1:
                return equipe.getNome();
            case 2:
                return equipe.getPontuacao();
            default:
                return "";
        }
    }  
    
}
