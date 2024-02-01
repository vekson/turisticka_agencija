package cs202.turagencija.entities;

import java.util.*;

public class Aranzman {

    private Integer id;
    private String odrediste;
    private String mestoPolaska;
    private List<Termin> terminList;
    private List<Aranzman> aranzmanAraList;
    private List<Vodic> vodicList;
    private Agencija agencija;
    private Aranzman aranzman;
    private PrevoznoSredstvo prevoznoSredstvo;

    public Aranzman() {
    }

    public Aranzman(Integer id, String odrediste, String mestoPolaska, List<Termin> terminList, List<Aranzman> aranzmanAraList, List<Vodic> vodicList, Agencija agencija, Aranzman aranzman, PrevoznoSredstvo prevoznoSredstvo) {
        this.id = id;
        this.odrediste = odrediste;
        this.mestoPolaska = mestoPolaska;
        this.terminList = terminList;
        this.aranzmanAraList = aranzmanAraList;
        this.vodicList = vodicList;
        this.agencija = agencija;
        this.aranzman = aranzman;
        this.prevoznoSredstvo = prevoznoSredstvo;
    }

    public Aranzman(String odrediste, String mestoPolaska, PrevoznoSredstvo prevoznoSredstvo, Agencija agencija) {
        this.odrediste = odrediste;
        this.mestoPolaska = mestoPolaska;
        this.prevoznoSredstvo = prevoznoSredstvo;
        this.agencija = agencija;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOdrediste() {
        return odrediste;
    }

    public void setOdrediste(String odrediste) {
        this.odrediste = odrediste;
    }

    public String getMestoPolaska() {
        return mestoPolaska;
    }

    public void setMestoPolaska(String mestoPolaska) {
        this.mestoPolaska = mestoPolaska;
    }

    public List<Termin> getTerminList() {
        return terminList;
    }

    public void setTerminList(List<Termin> terminList) {
        this.terminList = terminList;
    }

    public List<Aranzman> getAranzmanAraList() {
        return aranzmanAraList;
    }

    public void setAranzmanAraList(List<Aranzman> aranzmanAraList) {
        this.aranzmanAraList = aranzmanAraList;
    }

    public List<Vodic> getVodicList() {
        return vodicList;
    }

    public void setVodicList(List<Vodic> vodicList) {
        this.vodicList = vodicList;
    }

    public Agencija getAgencija() {
        return agencija;
    }

    public void setAgencija(Agencija agencija) {
        this.agencija = agencija;
    }

    public Aranzman getAranzman() {
        return aranzman;
    }

    public void setAranzman(Aranzman Aranzman) {
        this.aranzman = Aranzman;
    }

    public PrevoznoSredstvo getPrevoznoSredstvo() {
        return prevoznoSredstvo;
    }

    public void setPrevoznoSredstvo(PrevoznoSredstvo prevoznoSredstvo) {
        this.prevoznoSredstvo = prevoznoSredstvo;
    }

    @Override
    public String toString() {
        return "Aranzman{" + "id=" + id + ", odrediste=" + odrediste + ", mestoPolaska=" + mestoPolaska + ", terminList=" + terminList + ", aranzmanAraList=" + aranzmanAraList + ", vodicList=" + vodicList + ", agencija=" + agencija + ", Aranzman=" + aranzman + ", prevoznoSredstvo=" + prevoznoSredstvo + '}';
    }

}
