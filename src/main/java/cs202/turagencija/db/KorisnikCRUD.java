package cs202.turagencija.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import cs202.turagencija.entities.Korisnik;

public class KorisnikCRUD {

    /**
     * Method used for creating a korisnik and adding it to the 'KORISNIK'
     * table.
     *
     * @param korisnik A Korisnik object representing the korisnik to be
     * inserted.
     * @return The Korisnik object with its ID set after insertion.
     */
    public static Korisnik insertKorisnik(Korisnik korisnik) {
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement(
                    "INSERT INTO KORISNIK (TERMIN_ID, IME, PREZIME, ADRESA, BROJ_PASOSA) VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, korisnik.getTermin().getId());
            stmt.setString(2, korisnik.getIme());
            stmt.setString(3, korisnik.getPrezime());
            stmt.setString(4, korisnik.getAdresa());
            stmt.setInt(5, korisnik.getBrojPasosa());

            stmt.executeUpdate();
            ResultSet keys = stmt.getGeneratedKeys();

            while (keys.next()) {
                korisnik.setId(keys.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return korisnik;
    }

    /**
     * Method that reads all korisnici from the 'KORISNIK' table.
     *
     * @return A list of Korisnik objects representing all korisnici in the
     * table.
     * @throws SQLException
     */
    public static List<Korisnik> readAllKorisnici() throws SQLException {
        List<Korisnik> korisnici = new ArrayList<>();
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("SELECT * FROM KORISNIK");
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                Korisnik korisnik = new Korisnik();
                korisnik.setId(set.getInt("KORISNIK_ID"));
                korisnik.setTermin(TerminCRUD.getTerminById(set.getInt("TERMIN_ID")));
                korisnik.setIme(set.getString("IME"));
                korisnik.setPrezime(set.getString("PREZIME"));
                korisnik.setAdresa(set.getString("ADRESA"));
                korisnik.setBrojPasosa(set.getInt("BROJ_PASOSA"));
                korisnici.add(korisnik);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return korisnici;
    }

    /**
     * Method used for updating an existing korisnik in the 'KORISNIK' table.
     *
     * @param korisnik A Korisnik object representing the updated korisnik.
     */
    public static void updateKorisnik(Korisnik korisnik) {
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement(
                    "UPDATE KORISNIK SET TERMIN_ID=?, IME=?, PREZIME=?, ADRESA=?, BROJ_PASOSA=? WHERE KORISNIK_ID=?");
            stmt.setInt(1, korisnik.getTermin().getId());
            stmt.setString(2, korisnik.getIme());
            stmt.setString(3, korisnik.getPrezime());
            stmt.setString(4, korisnik.getAdresa());
            stmt.setInt(5, korisnik.getBrojPasosa());
            stmt.setInt(6, korisnik.getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method used for deleting a korisnik from the 'KORISNIK' table.
     *
     * @param korisnikId The ID of the korisnik to be deleted.
     */
    public static void deleteKorisnik(int korisnikId) {
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("DELETE FROM KORISNIK WHERE KORISNIK_ID=?");
            stmt.setInt(1, korisnikId);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method used for retrieving a korisnik by its ID from the 'KORISNIK'
     * table.
     *
     * @param korisnikId The ID of the korisnik to retrieve.
     * @return A Korisnik object representing the korisnik with the specified
     * ID, or null if not found.
     */
    public static Korisnik getKorisnikById(int korisnikId) {
        Korisnik korisnik = null;
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("SELECT * FROM KORISNIK WHERE KORISNIK_ID = ?");
            stmt.setInt(1, korisnikId);
            ResultSet set = stmt.executeQuery();
            if (set.next()) {
                korisnik = new Korisnik();
                korisnik.setId(set.getInt("KORISNIK_ID"));
                korisnik.setTermin(TerminCRUD.getTerminById(set.getInt("TERMIN_ID")));
                korisnik.setIme(set.getString("IME"));
                korisnik.setPrezime(set.getString("PREZIME"));
                korisnik.setAdresa(set.getString("ADRESA"));
                korisnik.setBrojPasosa(set.getInt("BROJ_PASOSA"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return korisnik;
    }

}
