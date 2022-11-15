package Controlers;

import Entities.Consultation;
import Entities.Medicament;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlMedicament
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlMedicament() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Medicament> GetAllMedicamentsByIdConsultations(int idConsultation)
    {
        ArrayList<Medicament> lesMedicaments = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("SELECT medicament.idMedoc, medicament.nomMedoc, medicament.prixMedoc\n" +
                    "FROM medicament, consultation\n" +
                    "WHERE medicament.idMedoc = consultation.idConsult");
            rs = ps.executeQuery();
            while (rs.next())
            {
                Medicament medoc = new Medicament(rs.getInt("idMedoc"), rs.getString("nomMedoc"),
                        rs.getDouble("prixMedoc"), rs.getInt("quantite"));
                lesMedicaments.add(medoc);
                // int unNum, String unNom,  double unPrix,int uneQte
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMedicament.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMedicaments;
    }
    public ArrayList<Medicament> getAllMedicaments()
    {
        ArrayList<Medicament> lesMedicaments = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("SELECT medicament.nomMedoc" +
                    "FROM medicament\n" +
                    "ORDER BY medicament.idMedicament ASC");
            rs = ps.executeQuery();
            while (rs.next()) {
                //Medicament med = new Medicament(rs.getString("nomMedicament"));
                //lesMedicaments.add(med);

            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMedicament.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMedicaments;
    }
}
