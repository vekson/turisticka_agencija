package cs202.turagencija.entities;

import java.util.*;

public class Vlasnik {

    private Integer id;
    private String jmbg;
    private String ime;
    private String prezime;
    private String adresa;
    private List<Agencija> agencijaList;

    public Vlasnik() {
    }

    public Vlasnik(Integer id, String jmbg, String ime, String prezime, String adresa, List<Agencija> agencijaList) {
        this.id = id;
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.agencijaList = agencijaList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public List<Agencija> getAgencijaList() {
        return agencijaList;
    }

    public void setAgencijaList(List<Agencija> agencijaList) {
        this.agencijaList = agencijaList;
    }

    @Override
    public String toString() {
        return "Vlasnik{" + "id=" + id + ", jmbg=" + jmbg + ", ime=" + ime + ", prezime=" + prezime + ", adresa=" + adresa + ", agencijaList=" + agencijaList + '}';
    }

}
