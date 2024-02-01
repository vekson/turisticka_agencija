package cs202.turagencija.entities;

import cs202.turagencija.enums.PrevozTip;
import java.util.*;

public class PrevoznoSredstvo {

    private Integer id;
    private PrevozTip tip;
    private Integer brojMesta;
    private List<Aranzman> arazmanList;

    public PrevoznoSredstvo() {
    }

    public PrevoznoSredstvo(Integer id, PrevozTip tip, Integer brojMesta, List<Aranzman> arazmanList) {
        this.id = id;
        this.tip = tip;
        this.brojMesta = brojMesta;
        this.arazmanList = arazmanList;
    }

    public Integer getId() {
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

    public List<Aranzman> getArazmanList() {
        return arazmanList;
    }

    public void setArazmanList(List<Aranzman> arazmanList) {
        this.arazmanList = arazmanList;
    }

    @Override
    public String toString() {
        return "PrevoznoSredstvo{" + "id=" + id + ", tip=" + tip + ", brojMesta=" + brojMesta + ", arazmanList=" + arazmanList + '}';
    }

}
