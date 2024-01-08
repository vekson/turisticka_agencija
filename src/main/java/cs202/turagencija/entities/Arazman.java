package cs202.turagencija.entities;

import java.util.*;

public class Arazman {

    public Integer id;
    public String odrediste;
    public String mestoPolaska;
    public List<Termin> terminList;
    public List<Arazman> arazmanAraList;
    public List<Vodic> vodicList;
    public Agencija agencijaList;
    public Arazman arazman;
    public PrevoznoSredstvo prevoznoSredstvo;

    public Arazman(Integer id, String odrediste, String mestoPolaska, List<Termin> terminList, List<Arazman> arazmanAraList, List<Vodic> vodicList, Agencija agencijaList, Arazman arazman, PrevoznoSredstvo prevoznoSredstvo) {
        this.id = id;
        this.odrediste = odrediste;
        this.mestoPolaska = mestoPolaska;
        this.terminList = terminList;
        this.arazmanAraList = arazmanAraList;
        this.vodicList = vodicList;
        this.agencijaList = agencijaList;
        this.arazman = arazman;
        this.prevoznoSredstvo = prevoznoSredstvo;
    }

    public long getId() {
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

    public List<Arazman> getArazmanAraList() {
        return arazmanAraList;
    }

    public void setArazmanAraList(List<Arazman> arazmanAraList) {
        this.arazmanAraList = arazmanAraList;
    }

    public List<Vodic> getVodicList() {
        return vodicList;
    }

    public void setVodicList(List<Vodic> vodicList) {
        this.vodicList = vodicList;
    }

    public Agencija getAgencijaList() {
        return agencijaList;
    }

    public void setAgencijaList(Agencija agencijaList) {
        this.agencijaList = agencijaList;
    }

    public Arazman getArazman() {
        return arazman;
    }

    public void setArazman(Arazman arazman) {
        this.arazman = arazman;
    }

    public PrevoznoSredstvo getPrevoznoSredstvo() {
        return prevoznoSredstvo;
    }

    public void setPrevoznoSredstvo(PrevoznoSredstvo prevoznoSredstvo) {
        this.prevoznoSredstvo = prevoznoSredstvo;
    }

    @Override
    public String toString() {
        return "Arazman{" + "id=" + id + ", odrediste=" + odrediste + ", mestoPolaska=" + mestoPolaska + ", terminList=" + terminList + ", arazmanAraList=" + arazmanAraList + ", vodicList=" + vodicList + ", agencijaList=" + agencijaList + ", arazman=" + arazman + ", prevoznoSredstvo=" + prevoznoSredstvo + '}';
    }

}
