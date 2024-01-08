package cs202.turagencija.entities;

import java.time.LocalDate;
import java.util.*;

public class Termin {

    public Integer id;
    public LocalDate datumPolaska;
    public LocalDate datumOdlaska;
    public Integer brojSlobodnihMesta;
    public List<Korisnik> korisnikList;
    public Arazman arazman;

    public Termin() {
    }

    public Termin(Integer id, LocalDate datumPolaska, LocalDate datumOdlaska, Integer brojSlobodnihMesta, List<Korisnik> korisnikList, Arazman arazman) {
        this.id = id;
        this.datumPolaska = datumPolaska;
        this.datumOdlaska = datumOdlaska;
        this.brojSlobodnihMesta = brojSlobodnihMesta;
        this.korisnikList = korisnikList;
        this.arazman = arazman;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDatumPolaska() {
        return datumPolaska;
    }

    public void setDatumPolaska(LocalDate datumPolaska) {
        this.datumPolaska = datumPolaska;
    }

    public LocalDate getDatumOdlaska() {
        return datumOdlaska;
    }

    public void setDatumOdlaska(LocalDate datumOdlaska) {
        this.datumOdlaska = datumOdlaska;
    }

    public Integer getBrojSlobodnihMesta() {
        return brojSlobodnihMesta;
    }

    public void setBrojSlobodnihMesta(Integer brojSlobodnihMesta) {
        this.brojSlobodnihMesta = brojSlobodnihMesta;
    }

    public List<Korisnik> getKorisnikList() {
        return korisnikList;
    }

    public void setKorisnikList(List<Korisnik> korisnikList) {
        this.korisnikList = korisnikList;
    }

    public Arazman getArazman() {
        return arazman;
    }

    public void setArazman(Arazman arazman) {
        this.arazman = arazman;
    }

    @Override
    public String toString() {
        return "Termin{" + "id=" + id + ", datumPolaska=" + datumPolaska + ", datumOdlaska=" + datumOdlaska + ", brojSlobodnihMesta=" + brojSlobodnihMesta + ", korisnikList=" + korisnikList + ", arazman=" + arazman + '}';
    }

}
