package Vues;

import Controlers.CtrlConsultation;
import Controlers.CtrlMedicament;
import Tools.ModelJTable;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmConsulter extends JFrame
{
    private JPanel pnlRoot;
    private JLabel lblTitre;
    private JLabel lblConsultations;
    private JTable tblConsultations;
    private JLabel lblMedicaments;
    private JTable tblMedicaments;
    private CtrlConsultation ctrlConsultation;
    private CtrlMedicament ctrlMedicament;
    private ModelJTable mdl;


    public FrmConsulter()
    {
        this.setTitle("Consulter");
        this.setContentPane(pnlRoot);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                // A vous de jouer
                ctrlConsultation = new CtrlConsultation();
                mdl = new ModelJTable();
                mdl.loadDatasConsultations(ctrlConsultation.GetAllConsultations());
                tblConsultations.setModel(mdl);


            }
        });
        tblConsultations.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // A vous de jouer

                // Remplissage du JTable tblMedicaments
                ctrlMedicament = new CtrlMedicament();
                mdl = new ModelJTable();
                // mdl.loadDatasMedicaments(ctrlMedicament.GetAllMedicamentsByIdConsultations(tblConsultations.getValueAt(tblConsultations.getSelectedRow(), 0).toString()));
                tblMedicaments.setModel(mdl);

            }
        });
    }
}
