package cs202.turagencija.db;

import cs202.turagencija.entities.PrevoznoSredstvo;
import cs202.turagencija.enums.PrevozTip;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PrevoznoSredstvoCRUD {

    /**
     * Method used for creating a prevozno sredstvo and adding it to the
     * 'PREVOZNO_SREDSTVO' table.
     *
     * @param prevoznoSredstvo A PrevoznoSredstvo object representing the
     * prevozno sredstvo to be inserted.
     * @return The PrevoznoSredstvo object with its ID set after insertion.
     */
    public static PrevoznoSredstvo insertPrevoznoSredstvo(PrevoznoSredstvo prevoznoSredstvo) {
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("INSERT INTO PREVOZNO_SREDSTVO (TIP, BROJ_MESTA) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, prevoznoSredstvo.getTip().toString());
            stmt.setInt(2, prevoznoSredstvo.getBrojMesta());

            stmt.executeUpdate();
            ResultSet keys = stmt.getGeneratedKeys();

            while (keys.next()) {
                prevoznoSredstvo.setId(keys.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return prevoznoSredstvo;
    }

    /**
     * Method that reads all prevozna sredstva from the 'PREVOZNO_SREDSTVO'
     * table.
     *
     * @return A list of PrevoznoSredstvo objects representing all prevozna
     * sredstva in the table.
     * @throws SQLException
     */
    public static List<PrevoznoSredstvo> readAllPrevoznaSredstva() throws SQLException {
        List<PrevoznoSredstvo> prevoznaSredstva = new ArrayList<>();
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("SELECT * FROM PREVOZNO_SREDSTVO");
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                PrevoznoSredstvo prevoznoSredstvo = new PrevoznoSredstvo();
                prevoznoSredstvo.setId(set.getInt("PREVOZNO_SREDSTVO_ID"));
                prevoznoSredstvo.setTip(PrevozTip.valueOf(set.getString("TIP")));
                prevoznoSredstvo.setBrojMesta(set.getInt("BROJ_MESTA"));
                prevoznaSredstva.add(prevoznoSredstvo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return prevoznaSredstva;
    }

    /**
     * Method used for updating an existing prevozno sredstvo in the
     * 'PREVOZNO_SREDSTVO' table.
     *
     * @param prevoznoSredstvo A PrevoznoSredstvo object representing the
     * updated prevozno sredstvo.
     */
    public static void updatePrevoznoSredstvo(PrevoznoSredstvo prevoznoSredstvo) {
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("UPDATE PREVOZNO_SREDSTVO SET TIP=?, BROJ_MESTA=? WHERE PREVOZNO_SREDSTVO_ID=?");
            stmt.setString(1, prevoznoSredstvo.getTip().toString());
            stmt.setInt(2, prevoznoSredstvo.getBrojMesta());
            stmt.setInt(3, prevoznoSredstvo.getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method used for deleting a prevozno sredstvo from the 'PREVOZNO_SREDSTVO'
     * table.
     *
     * @param prevoznoSredstvoId The ID of the prevozno sredstvo to be deleted.
     */
    public static void deletePrevoznoSredstvo(int prevoznoSredstvoId) {
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("DELETE FROM PREVOZNO_SREDSTVO WHERE PREVOZNO_SREDSTVO_ID=?");
            stmt.setInt(1, prevoznoSredstvoId);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method used for retrieving a prevozno sredstvo by its ID from the
     * 'PREVOZNO_SREDSTVO' table.
     *
     * @param prevoznoSredstvoId The ID of the prevozno sredstvo to retrieve.
     * @return A PrevoznoSredstvo object representing the prevozno sredstvo with
     * the specified ID, or null if not found.
     */
    public static PrevoznoSredstvo getPrevoznoSredstvoById(int prevoznoSredstvoId) {
        PrevoznoSredstvo prevoznoSredstvo = null;
        try {
            DBUtil.openConnection();
            PreparedStatement stmt = DBUtil.con.prepareStatement("SELECT * FROM PREVOZNO_SREDSTVO WHERE PREVOZNO_SREDSTVO_ID = ?");
            stmt.setInt(1, prevoznoSredstvoId);
            ResultSet set = stmt.executeQuery();
            if (set.next()) {
                prevoznoSredstvo = new PrevoznoSredstvo();
                prevoznoSredstvo.setId(set.getInt("PREVOZNO_SREDSTVO_ID"));
                prevoznoSredstvo.setTip(PrevozTip.valueOf(set.getString("TIP")));
                prevoznoSredstvo.setBrojMesta(set.getInt("BROJ_MESTA"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return prevoznoSredstvo;
    }
}
