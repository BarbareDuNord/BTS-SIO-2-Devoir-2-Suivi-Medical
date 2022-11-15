package Tools;



import Entities.Consultation;
import Entities.Medicament;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModelJTable extends AbstractTableModel {
    private String[] colonnes;
    private Object[][] lignes;

    @Override
    public String getColumnName(int column) {
        return colonnes[column];
    }

    @Override
    public int getRowCount() {
        return lignes.length;
    }

    @Override
    public int getColumnCount() {
        return colonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return lignes[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        lignes[row][column] = value;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 3 ;
    }

    public void loadDatasConsultations(ArrayList<Consultation> lesConsultations){
        /*
         * FONCTION QUI LIT LES DONNEES DE L'ARRAYLIST lesActivites
         * */
        // Tableau en 1D contenant le nom des colonnes du JTable
        colonnes = new String[]{"Numéro", "Date", "Nom du patient", "Nom du médicament", "Montant"};

        lignes = new Object[lesConsultations.size()][4];
        //rows = new Vector<>();
        int i = 0;
        // On parcourt l'arrayList lesActivités pour lire ses lignes aux colonnes 0 et 1
        for (Consultation cons: lesConsultations) {
            lignes[i][0] = cons.getNumero();
            lignes[i][1] = cons.getDate();
            lignes[i][1] = cons.getNomPatient();
            lignes[i][1] = cons.getNomMedecin();
            lignes[i][1] = cons.getMontant();
            i++;
        }
        fireTableChanged(null);
    }

    public void loadDatasMedicaments(ArrayList<Medicament> lesMedicaments){

    }
}
