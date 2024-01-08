/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs202.turagencija.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author korisnik
 */
public class DBUtil {

    public static Connection con = null;
    private static String url = "jdbc:mysql://localhost:3306/";
    private static String dbName = "turisticka_agencija";
    private static String username = "root";
    private static String password = "";

    /**
     * Method for connecting to the base, checking if everything every table is
     * created and if it isn't then it creates it
     */
    public static void initDB() {

        try {
            con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            stmt.execute("CREATE DATABASE IF NOT EXISTS " + dbName);
            stmt.execute("USE " + dbName);
            // Create vlasnik table
            stmt.execute("CREATE TABLE IF NOT EXISTS vlasnik("
                    + "vlasnik_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                    + "jmbg VARCHAR(13) NOT NULL,"
                    + "ime VARCHAR(20) NOT NULL,"
                    + "prezime VARCHAR(20) NOT NULL,"
                    + "adresa VARCHAR(50)"
                    + ")");

            // Create agencija table with foreign key
            stmt.execute("CREATE TABLE IF NOT EXISTS agencija("
                    + "sifra_agencije VARCHAR(10) NOT NULL PRIMARY KEY,"
                    + "vlasnik_id INT NOT NULL,"
                    + "naziv VARCHAR(50) NOT NULL,"
                    + "adresa VARCHAR(50),"
                    + "CONSTRAINT FK_VODJENJE FOREIGN KEY (vlasnik_id) "
                    + "REFERENCES vlasnik (vlasnik_id) ON DELETE RESTRICT ON UPDATE RESTRICT"
                    + ")");

            // Create prevozno_sredstvo table
            stmt.execute("CREATE TABLE IF NOT EXISTS prevozno_sredstvo("
                    + "prevozno_sredstvo_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                    + "tip VARCHAR(30) NOT NULL,"
                    + "broj_mesta INT NOT NULL"
                    + ")");

            // Create arazman table with foreign keys
            stmt.execute("CREATE TABLE IF NOT EXISTS arazman("
                    + "arazman_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                    + "sifra_agencije VARCHAR(10) NOT NULL,"
                    + "ara_arazman_id INT,"
                    + "prevozno_sredstvo_id INT NOT NULL,"
                    + "odrediste VARCHAR(50) NOT NULL,"
                    + "mesto_polaska VARCHAR(50) NOT NULL,"
                    + "CONSTRAINT FK_OBAVLJANJE FOREIGN KEY (sifra_agencije) "
                    + "REFERENCES agencija (sifra_agencije) ON DELETE RESTRICT ON UPDATE RESTRICT,"
                    + "CONSTRAINT FK_PREVOZI FOREIGN KEY (prevozno_sredstvo_id) "
                    + "REFERENCES prevozno_sredstvo (prevozno_sredstvo_id) ON DELETE RESTRICT ON UPDATE RESTRICT,"
                    + "CONSTRAINT FK_ZAMENSKO_PUTOVANJE FOREIGN KEY (ara_arazman_id) "
                    + "REFERENCES arazman (arazman_id) ON DELETE RESTRICT ON UPDATE RESTRICT"
                    + ")");

            // Create termin table with foreign key
            stmt.execute("CREATE TABLE IF NOT EXISTS termin("
                    + "termin_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                    + "arazman_id INT NOT NULL,"
                    + "datum_polaska DATE NOT NULL,"
                    + "datum_odlaska DATE NOT NULL,"
                    + "broj_slobodnih_mesta INT NOT NULL,"
                    + "CONSTRAINT FK_ORGANIZOVANJE FOREIGN KEY (arazman_id) "
                    + "REFERENCES arazman (arazman_id) ON DELETE RESTRICT ON UPDATE RESTRICT"
                    + ")");

            // Create korisnik table with foreign key
            stmt.execute("CREATE TABLE IF NOT EXISTS korisnik("
                    + "korisnik_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                    + "termin_id INT NOT NULL,"
                    + "ime VARCHAR(20) NOT NULL,"
                    + "prezime VARCHAR(20) NOT NULL,"
                    + "adresa VARCHAR(50),"
                    + "broj_pasosa INT,"
                    + "CONSTRAINT FK_BIRA FOREIGN KEY (termin_id) "
                    + "REFERENCES termin (termin_id) ON DELETE RESTRICT ON UPDATE RESTRICT"
                    + ")");

            // Create vodic table with foreign key
            stmt.execute("CREATE TABLE IF NOT EXISTS vodic("
                    + "vodic_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                    + "arazman_id INT NOT NULL,"
                    + "ime VARCHAR(20) NOT NULL,"
                    + "prezime VARCHAR(20) NOT NULL,"
                    + "starost INT,"
                    + "godine_rada INT,"
                    + "CONSTRAINT FK_RELATIONSHIP_5 FOREIGN KEY (arazman_id) "
                    + "REFERENCES arazman (arazman_id) ON DELETE RESTRICT ON UPDATE RESTRICT"
                    + ")");

        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method for opening connection
     *
     * @throws SQLException
     */
    public static void openConnection() throws SQLException {
        con = DriverManager.getConnection(url + dbName, username, password);
    }

    /**
     * Method for closing connection
     *
     * @throws SQLException
     */
    public static void closeConnection() throws SQLException {
        con.close();
    }
}
