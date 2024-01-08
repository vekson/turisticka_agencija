package cs202.turagencija.entities;

import java.util.*;

public class Agencija {

    public String sifra;
    public String naziv;
    public String adresa;
    public List<Arazman> arazmanList;
    public Vlasnik vlasnik;

    public Agencija() {
    }

    public Agencija(String sifra, String naziv, String adresa, List<Arazman> arazmanList, Vlasnik vlasnik) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.adresa = adresa;
        this.arazmanList = arazmanList;
        this.vlasnik = vlasnik;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public List<Arazman> getArazmanList() {
        return arazmanList;
    }

    public void setArazmanList(List<Arazman> arazmanList) {
        this.arazmanList = arazmanList;
    }

    public Vlasnik getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(Vlasnik vlasnik) {
        this.vlasnik = vlasnik;
    }

    @Override
    public String toString() {
        return "Agencija{" + "sifra=" + sifra + ", naziv=" + naziv + ", adresa=" + adresa + ", arazmanList=" + arazmanList + ", vlasnik=" + vlasnik + '}';
    }

}
