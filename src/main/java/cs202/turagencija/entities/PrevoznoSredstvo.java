package cs202.turagencija.entities;

import cs202.turagencija.enums.PrevozTip;
import java.util.*;

public class PrevoznoSredstvo {

    public Integer id;
    public PrevozTip tip;
    public Integer brojMesta;
    public List<Arazman> arazmanList;

    public PrevoznoSredstvo() {
    }

    public PrevoznoSredstvo(Integer id, PrevozTip tip, Integer brojMesta, List<Arazman> arazmanList) {
        this.id = id;
        this.tip = tip;
        this.brojMesta = brojMesta;
        this.arazmanList = arazmanList;
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PrevozTip getTip() {
        return tip;
    }

    public void setTip(PrevozTip tip) {
        this.tip = tip;
    }

    public Integer getBrojMesta() {
        return brojMesta;
    }

    public void setBrojMesta(Integer brojMesta) {
        this.brojMesta = brojMesta;
    }

    public List<Arazman> getArazmanList() {
        return arazmanList;
    }

    public void setArazmanList(List<Arazman> arazmanList) {
        this.arazmanList = arazmanList;
    }

    @Override
    public String toString() {
        return "PrevoznoSredstvo{" + "id=" + id + ", tip=" + tip + ", brojMesta=" + brojMesta + ", arazmanList=" + arazmanList + '}';
    }

}
