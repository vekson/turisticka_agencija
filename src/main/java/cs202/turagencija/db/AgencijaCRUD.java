package cs202.turagencija.db;

import cs202.turagencija.entities.Agencija;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AgencijaCRUD {

    /**
     * Method used for creating an agencija and adding it to the 'AGENCIJA'
     * table.
     *
     * @param agencija An Agencija object representing the agencija to be
     * inserted.
     * @return The Agencija object with its ID set after insertion.
     */
    public static Agencija insertAgencija(Agencija agencija) {
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("INSERT INTO AGENCIJA (SIFRA_AGENCIJE, VLASNIK_ID, NAZIV, ADRESA) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, agencija.getSifra());
            stmt.setInt(2, 1);
            stmt.setString(3, agencija.getNaziv());
            stmt.setString(4, agencija.getAdresa());

            stmt.executeUpdate();
            ResultSet keys = stmt.getGeneratedKeys();

            while (keys.next()) {
                agencija.setSifra(keys.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return agencija;
    }

    /**
     * Method that reads all agencije from the 'AGENCIJA' table.
     *
     * @return A list of Agencija objects representing all agencije in the
     * table.
     * @throws SQLException
     */
    public static List<Agencija> readAllAgencije() throws SQLException {
        List<Agencija> agencije = new ArrayList<>();
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("SELECT * FROM AGENCIJA");
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                Agencija agencija = new Agencija();
                agencija.setSifra(set.getString("SIFRA_AGENCIJE"));
                agencija.setVlasnik(VlasnikCRUD.getVlasnikById(set.getInt("VLASNIK_ID")));
                agencija.setNaziv(set.getString("NAZIV"));
                agencija.setAdresa(set.getString("ADRESA"));
                agencije.add(agencija);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return agencije;
    }

    /**
     * Method used for updating an existing agencija in the 'AGENCIJA' table.
     *
     * @param agencija An Agencija object representing the updated agencija.
     */
    public static void updateAgencija(Agencija agencija) {
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("UPDATE AGENCIJA SET VLASNIK_ID=?, NAZIV=?, ADRESA=? WHERE SIFRA_AGENCIJE=?");
            stmt.setInt(1, agencija.getVlasnik().getId());
            stmt.setString(2, agencija.getNaziv());
            stmt.setString(3, agencija.getAdresa());
            stmt.setString(4, agencija.getSifra());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method used for deleting an agencija from the 'AGENCIJA' table.
     *
     * @param agencijaId The ID of the agencija to be deleted.
     */
    public static void deleteAgencija(int agencijaId) {
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("DELETE FROM AGENCIJA WHERE AGENCIJA_ID=?");
            stmt.setInt(1, agencijaId);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method used for retrieving an agencija by its ID from the 'AGENCIJA'
     * table.
     *
     * @param sifra The ID of the agencija to retrieve.
     * @return An Agencija object representing the agencija with the specified
     * ID, or null if not found.
     */
    public static Agencija getAgencijaBySifraAgencije(String sifra) {
        Agencija agencija = null;
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("SELECT * FROM AGENCIJA WHERE SIFRA_AGENCIJE = ?");
            stmt.setString(1, sifra);
            ResultSet set = stmt.executeQuery();
            if (set.next()) {
                agencija = new Agencija();
                agencija.setSifra(set.getString("SIFRA_AGENCIJE"));
                agencija.setVlasnik(VlasnikCRUD.getVlasnikById(set.getInt("VLASNIK_ID")));
                agencija.setNaziv(set.getString("NAZIV"));
                agencija.setAdresa(set.getString("ADRESA"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return agencija;
    }
}
