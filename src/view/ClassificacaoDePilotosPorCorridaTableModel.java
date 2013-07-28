package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Piloto;

public class ClassificacaoDePilotosPorCorridaTableModel extends AbstractTableModel{

    private enum columns{
        Posição,
        Nome,
        Equipe,
        Pontos,
    }
    
    private List<Piloto> valores;

    public ClassificacaoDePilotosPorCorridaTableModel() {
        valores = new ArrayList<Piloto>();
    }
    
    public ClassificacaoDePilotosPorCorridaTableModel(List<Piloto> valores) {
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
    
    @Override
    public int getRowCount() {
        return valores.size();
    }

    @Override
    public int getColumnCount() {
        return columns.values().length;
    }
    
    public String getColumnName(int columnIndex){
        return columns.values()[columnIndex].toString();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return rowIndex+1;
            case 1:
                return valores.get(rowIndex).getNome();
            case 2:
                return valores.get(rowIndex).getCarro().getEquipe().getNome();
            case 3:
                return valores.get(rowIndex).getPontuacao();
            default:
                return "";
        }
    }
    
    
    
}
