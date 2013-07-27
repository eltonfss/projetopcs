package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class CorridasComboBoxModel implements ComboBoxModel{

    List<Integer> numerosDeCorridas;
    Integer selectedIndex;

    public CorridasComboBoxModel(List<Integer> numerosDeCorridas) {
        this.numerosDeCorridas = numerosDeCorridas;
        this.selectedIndex = 0;
    }

    public CorridasComboBoxModel() {
        numerosDeCorridas = new ArrayList<Integer>();
        selectedIndex = 0;
    }
    
    @Override
    public void setSelectedItem(Object anItem) {
        selectedIndex = numerosDeCorridas.indexOf(anItem);
    }

    @Override
    public Object getSelectedItem() {
        return numerosDeCorridas.get(selectedIndex);
    }

    @Override
    public int getSize() {
        return numerosDeCorridas.size();
    }

    @Override
    public Object getElementAt(int index) {
        return numerosDeCorridas.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
    }
    
}
