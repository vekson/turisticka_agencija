package cs202.turagencija.entities;

import java.util.*;

public class Agencija {

    private String sifra;
    private String naziv;
    private String adresa;
    private List<Aranzman> aranzmanList;
    private Vlasnik vlasnik;

    public Agencija() {
    }

    public Agencija(String sifra, String naziv, String adresa, List<Aranzman> aranzmanList, Vlasnik vlasnik) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.adresa = adresa;
        this.aranzmanList = aranzmanList;
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

    public List<Aranzman> getAranzmanList() {
        return aranzmanList;
    }

    public void setAranzmanList(List<Aranzman> aranzmanList) {
        this.aranzmanList = aranzmanList;
    }

    public Vlasnik getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(Vlasnik vlasnik) {
        this.vlasnik = vlasnik;
    }

    @Override
    public String toString() {
        return "Agencija{" + "sifra=" + sifra + ", naziv=" + naziv + ", adresa=" + adresa + ", aranzmanList=" + aranzmanList + ", vlasnik=" + vlasnik + '}';
    }

}
