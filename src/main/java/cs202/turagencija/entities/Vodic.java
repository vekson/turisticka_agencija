package cs202.turagencija.entities;


public class Vodic {

    public Integer id;
    public String ime;
    public String prezime;
    public Integer starost;
    public Integer godineRada;
    public Arazman arazman;

    public Vodic() {
    }

    public Vodic(Integer id, String ime, String prezime, Integer starost, Integer godineRada, Arazman arazman) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.starost = starost;
        this.godineRada = godineRada;
        this.arazman = arazman;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getStarost() {
        return starost;
    }

    public void setStarost(Integer starost) {
        this.starost = starost;
    }

    public Integer getGodineRada() {
        return godineRada;
    }

    public void setGodineRada(Integer godineRada) {
        this.godineRada = godineRada;
    }

    public Arazman getArazman() {
        return arazman;
    }

    public void setArazman(Arazman arazman) {
        this.arazman = arazman;
    }

    @Override
    public String toString() {
        return "Vodic{" + "id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", starost=" + starost + ", godineRada=" + godineRada + ", arazman=" + arazman + '}';
    }

}
