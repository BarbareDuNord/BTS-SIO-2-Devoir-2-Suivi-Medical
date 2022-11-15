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

public class CtrlPatient
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlPatient() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<String> getAllPatients()
    {
        ArrayList<String> lesPatients = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("SELECT patient.nomPatient" +
                    "FROM patient\n" +
                    "ORDER BY patient.idPatient ASC");
            rs = ps.executeQuery();
            while (rs.next()) {
                String med = new String(rs.getString("nomPatient"));
                lesPatients.add(med);

            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesPatients;
    }
    public int getIdPatientByName(String nomPat)
    {
        // int[] lesIdPatient;
        // lesIdPatient = new int[];
        try {
            ps = cnx.prepareStatement("SELECT patient.idPatient" +
                    "FROM patient\n" +
                    "ORDER BY patient.nomPatient");
            rs = ps.executeQuery();
            while (rs.next()) {
                // pat = new int (rs.getInt("idPatient"));
                // lesIdMedecins.add(Integer.valueOf(pat));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return lesIdPatient;

        return 0;
    }
}
