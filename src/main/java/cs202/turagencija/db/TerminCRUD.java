package cs202.turagencija.db;

import cs202.turagencija.entities.Termin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TerminCRUD {

    /**
     * Method used for creating a termin and adding it to the 'TERMIN' table.
     *
     * @param termin A Termin object representing the termin to be inserted.
     * @return The Termin object with its ID set after insertion.
     */
    public static Termin insertTermin(Termin termin) {
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement(
                    "INSERT INTO TERMIN (ARANZMAN_ID, DATUM_POLASKA, DATUM_ODLASKA, BROJ_SLOBODNIH_MESTA) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, termin.getAranzman().getId());
            stmt.setString(2, termin.getDatumPolaska().toString());
            stmt.setString(3, termin.getDatumOdlaska().toString());
            stmt.setInt(4, termin.getBrojSlobodnihMesta());

            stmt.executeUpdate();
            ResultSet keys = stmt.getGeneratedKeys();

            while (keys.next()) {
                termin.setId(keys.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return termin;
    }

    /**
     * Method that reads all termins from the 'TERMIN' table.
     *
     * @return A list of Termin objects representing all termins in the table.
     * @throws SQLException
     */
    public static List<Termin> readAllTermini() throws SQLException {
        List<Termin> termini = new ArrayList<>();
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("SELECT * FROM TERMIN");
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                Termin termin = new Termin();
                termin.setId(set.getInt("TERMIN_ID"));
                termin.setAranzman(AranzmanCRUD.getAranzmanById(set.getInt("ARANZMAN_ID")));
                termin.setDatumPolaska(LocalDate.parse(set.getString("DATUM_POLASKA")));
                termin.setDatumOdlaska(LocalDate.parse(set.getString("DATUM_ODLASKA")));
                termin.setBrojSlobodnihMesta(set.getInt("BROJ_SLOBODNIH_MESTA"));
                termini.add(termin);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return termini;
    }

    /**
     * Method used for updating an existing termin in the 'TERMIN' table.
     *
     * @param termin A Termin object representing the updated termin.
     */
    public static void updateTermin(Termin termin) {
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement(
                    "UPDATE TERMIN SET ARANZMAN_ID=?, DATUM_POLASKA=?, DATUM_ODLASKA=?, BROJ_SLOBODNIH_MESTA=? WHERE TERMIN_ID=?");
            stmt.setInt(1, termin.getAranzman().getId());
            stmt.setString(2, termin.getDatumPolaska().toString());
            stmt.setString(3, termin.getDatumOdlaska().toString());
            stmt.setInt(4, termin.getBrojSlobodnihMesta());
            stmt.setInt(5, termin.getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method used for deleting a termin from the 'TERMIN' table.
     *
     * @param terminId The ID of the termin to be deleted.
     */
    public static void deleteTermin(int terminId) {
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("DELETE FROM TERMIN WHERE TERMIN_ID=?");
            stmt.setInt(1, terminId);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method used for retrieving a termin by its ID from the 'TERMIN' table.
     *
     * @param terminId The ID of the termin to retrieve.
     * @return A Termin object representing the termin with the specified ID, or
     * null if not found.
     */
    public static Termin getTerminById(int terminId) {
        Termin termin = null;
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("SELECT * FROM TERMIN WHERE TERMIN_ID = ?");
            stmt.setInt(1, terminId);
            ResultSet set = stmt.executeQuery();
            if (set.next()) {
                termin = new Termin();
                termin.setId(set.getInt("TERMIN_ID"));
                termin.setAranzman(AranzmanCRUD.getAranzmanById(set.getInt("ARANZMAN_ID")));
                termin.setDatumPolaska(LocalDate.parse(set.getString("DATUM_POLASKA")));
                termin.setDatumOdlaska(LocalDate.parse(set.getString("DATUM_ODLASKA")));
                termin.setBrojSlobodnihMesta(set.getInt("BROJ_SLOBODNIH_MESTA"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return termin;
    }
}
