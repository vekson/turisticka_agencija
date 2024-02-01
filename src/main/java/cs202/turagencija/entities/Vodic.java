package cs202.turagencija.entities;


public class Vodic {

    private Integer id;
    private String ime;
    private String prezime;
    private Integer starost;
    private Integer godineRada;
    private Aranzman aranzman;

    public Vodic() {
    }

    public Vodic(Integer id, String ime, String prezime, Integer starost, Integer godineRada, Aranzman aranzman) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.starost = starost;
        this.godineRada = godineRada;
        this.aranzman = aranzman;
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

    public Aranzman getAranzman() {
        return aranzman;
    }

    public void setAranzman(Aranzman aranzman) {
        this.aranzman = aranzman;
    }

    @Override
    public String toString() {
        return "Vodic{" + "id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", starost=" + starost + ", godineRada=" + godineRada + ", aranzman=" + aranzman + '}';
    }

}
