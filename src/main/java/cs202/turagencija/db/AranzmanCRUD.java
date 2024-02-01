package cs202.turagencija.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import cs202.turagencija.entities.Aranzman;

public class AranzmanCRUD {

    /**
     * Method used for creating an aranzman and adding it to the 'ARANZMAN'
     * table.
     *
     * @param aranzman An Aranzman object representing the aranzman to be
     * inserted.
     * @return The Aranzman object with its ID set after insertion.
     */
    public static Aranzman insertAranzman(Aranzman aranzman) {
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("INSERT INTO ARANZMAN (SIFRA_AGENCIJE, PREVOZNO_SREDSTVO_ID, ODREDISTE, MESTO_POLASKA) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, aranzman.getAgencija().getSifra());
            stmt.setInt(2, aranzman.getPrevoznoSredstvo().getId());
            stmt.setString(3, aranzman.getOdrediste());
            stmt.setString(4, aranzman.getMestoPolaska());

            stmt.executeUpdate();
            ResultSet keys = stmt.getGeneratedKeys();

            while (keys.next()) {
                aranzman.setId(keys.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return aranzman;
    }

    /**
     * Method that reads all aranzmani from the 'ARANZMAN' table.
     *
     * @return A list of Aranzman objects representing all aranzmani in the
     * table.
     * @throws SQLException
     */
    public static List<Aranzman> readAllAranzmani() throws SQLException {
        List<Aranzman> aranzmani = new ArrayList<>();
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("SELECT * FROM ARANZMAN");
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                Aranzman aranzman = new Aranzman();
                aranzman.setId(set.getInt("ARANZMAN_ID"));
                aranzman.setAgencija(AgencijaCRUD.getAgencijaBySifraAgencije(set.getString("SIFRA_AGENCIJE")));
                aranzman.setPrevoznoSredstvo(PrevoznoSredstvoCRUD.getPrevoznoSredstvoById(set.getInt("PREVOZNO_SREDSTVO_ID")));
                aranzman.setOdrediste(set.getString("ODREDISTE"));
                aranzman.setMestoPolaska(set.getString("MESTO_POLASKA"));
                aranzmani.add(aranzman);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return aranzmani;
    }

    /**
     * Method used for updating an existing aranzman in the 'ARANZMAN' table.
     *
     * @param aranzman An Aranzman object representing the updated aranzman.
     */
    public static void updateAranzman(Aranzman aranzman) {
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("UPDATE ARANZMAN SET SIFRA_AGENCIJE=?, PREVOZNO_SREDSTVO_ID=?, ODREDISTE=?, MESTO_POLASKA=? WHERE ARANZMAN_ID=?");
            stmt.setString(1, aranzman.getAgencija().getSifra());
            stmt.setLong(2, aranzman.getPrevoznoSredstvo().getId());
            stmt.setString(3, aranzman.getOdrediste());
            stmt.setString(4, aranzman.getMestoPolaska());
            stmt.setLong(5, aranzman.getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method used for deleting an aranzman from the 'ARANZMAN' table.
     *
     * @param aranzmanId The ID of the aranzman to be deleted.
     */
    public static void deleteAranzman(int aranzmanId) {
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("DELETE FROM ARANZMAN WHERE ARANZMAN_ID=?");
            stmt.setInt(1, aranzmanId);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
