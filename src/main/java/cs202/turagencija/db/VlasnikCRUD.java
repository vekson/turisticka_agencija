package cs202.turagencija.db;

import cs202.turagencija.entities.Vlasnik;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VlasnikCRUD {

    /**
     * Method used for creating a vlasnik and adding it to the 'VLASNIK' table.
     *
     * @param vlasnik A Vlasnik object representing the vlasnik to be inserted.
     * @return The Vlasnik object with its ID set after insertion.
     */
    public static Vlasnik insertVlasnik(Vlasnik vlasnik) {
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("INSERT INTO VLASNIK (JMBG, IME, PREZIME, ADRESA) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, vlasnik.getJmbg());
            stmt.setString(2, vlasnik.getIme());
            stmt.setString(3, vlasnik.getPrezime());
            stmt.setString(4, vlasnik.getAdresa());

            stmt.executeUpdate();
            ResultSet keys = stmt.getGeneratedKeys();

            while (keys.next()) {
                vlasnik.setId(keys.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vlasnik;
    }

    /**
     * Method that reads all vlasnici from the 'VLASNIK' table.
     *
     * @return A list of Vlasnik objects representing all vlasnici in the table.
     * @throws SQLException
     */
    public static List<Vlasnik> readAllVlasnici() throws SQLException {
        List<Vlasnik> vlasnici = new ArrayList<>();
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("SELECT * FROM VLASNIK");
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                Vlasnik vlasnik = new Vlasnik();
                vlasnik.setId(set.getInt("VLASNIK_ID"));
                vlasnik.setJmbg(set.getString("JMBG"));
                vlasnik.setIme(set.getString("IME"));
                vlasnik.setPrezime(set.getString("PREZIME"));
                vlasnik.setAdresa(set.getString("ADRESA"));
                vlasnici.add(vlasnik);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vlasnici;
    }

    /**
     * Method used for updating an existing vlasnik in the 'VLASNIK' table.
     *
     * @param vlasnik A Vlasnik object representing the updated vlasnik.
     */
    public static void updateVlasnik(Vlasnik vlasnik) {
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("UPDATE VLASNIK SET JMBG=?, IME=?, PREZIME=?, ADRESA=? WHERE VLASNIK_ID=?");
            stmt.setString(1, vlasnik.getJmbg());
            stmt.setString(2, vlasnik.getIme());
            stmt.setString(3, vlasnik.getPrezime());
            stmt.setString(4, vlasnik.getAdresa());
            stmt.setInt(5, vlasnik.getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method used for deleting a vlasnik from the 'VLASNIK' table.
     *
     * @param vlasnikId The ID of the vlasnik to be deleted.
     */
    public static void deleteVlasnik(int vlasnikId) {
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("DELETE FROM VLASNIK WHERE VLASNIK_ID=?");
            stmt.setInt(1, vlasnikId);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method used for retrieving a vlasnik by its ID from the 'VLASNIK' table.
     *
     * @param vlasnikId The ID of the vlasnik to retrieve.
     * @return A Vlasnik object representing the vlasnik with the specified ID, or null if not found.
     */
    public static Vlasnik getVlasnikById(int vlasnikId) {
        Vlasnik vlasnik = null;
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("SELECT * FROM VLASNIK WHERE VLASNIK_ID = ?");
            stmt.setInt(1, vlasnikId);
            ResultSet set = stmt.executeQuery();
            if (set.next()) {
                vlasnik = new Vlasnik();
                vlasnik.setId(set.getInt("VLASNIK_ID"));
                vlasnik.setJmbg(set.getString("JMBG"));
                vlasnik.setIme(set.getString("IME"));
                vlasnik.setPrezime(set.getString("PREZIME"));
                vlasnik.setAdresa(set.getString("ADRESA"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vlasnik;
    }
}