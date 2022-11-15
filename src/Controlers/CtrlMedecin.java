package Controlers;

import Entities.Medicament;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlMedecin
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlMedecin() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<String> getAllMedecins()
    {
        ArrayList<String> lesMedecins = new ArrayList<>();
        try {
            ps = cnx.prepareStatement("SELECT medecin.nomMedecin" +
                    "FROM medecin\n" +
                    "ORDER BY medecin.idMedecin ASC");
            rs = ps.executeQuery();
            while (rs.next()) {
                String med = new String(rs.getString("nomMedecin"));
                lesMedecins.add(med);

            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMedecin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMedecins;
    }

    public int getIdMedecinByName()
    {
        // int[] lesIdMedecins;
        // lesIdMedecins = new int[];
        try {
            ps = cnx.prepareStatement("SELECT medecin.idMedecin" +
                    "FROM medecin\n" +
                    "ORDER BY medecin.nomMedecin");
            rs = ps.executeQuery();
            while (rs.next()) {
                // med = new String(rs.getInt("idMedecin"));
                //lesIdMedecins.add(Integer.valueOf(med));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CtrlMedecin.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return lesIdMedecins;

        return 0;
    }
}
