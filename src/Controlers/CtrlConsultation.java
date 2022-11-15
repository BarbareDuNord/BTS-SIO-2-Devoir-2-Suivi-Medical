package Controlers;

import Entities.Consultation;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlConsultation
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlConsultation() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Consultation> GetAllConsultations()
    {
        ArrayList<Consultation> lesConsultations = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("SELECT consultation.dateConsultation" +
                    "FROM consultation\n" +
                    "ORDER BY consultation.dateConsultation ASC");
            rs = ps.executeQuery();
            while (rs.next()) {
                // Consultation cons = new Consultation(rs.getString("dateConsult"));
                // lesConsultations.add(cons);

            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlConsultation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesConsultations;
    }
    public int getLastNumberOfConsultation()
    {

        return 0;
    }
    public void InsertConsultation(int idConsult, String dateConsultation, int numPatient,int numMedecin)
    {
        try {
            ps = cnx.prepareStatement("insert into consultation values (?,?,?,?)");
            ps.setObject(1, null);
            ps.setString(2, dateConsultation);
            ps.setInt(3, numPatient);
            ps.setInt(4, numMedecin);
            ps.executeUpdate();
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlConsultation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
