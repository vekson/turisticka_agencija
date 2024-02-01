package cs202.turagencija.entities;

public class Korisnik {

    private Integer id;
    private String ime;
    private String prezime;
    private String adresa;
    private Integer brojPasosa;
    private Termin termin;

    public Korisnik() {
    }

    public Korisnik(Integer id, String ime, String prezime, String adresa, Integer brojPasosa, Termin termin) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.brojPasosa = brojPasosa;
        this.termin = termin;
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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Integer getBrojPasosa() {
        return brojPasosa;
    }

    public void setBrojPasosa(Integer brojPasosa) {
        this.brojPasosa = brojPasosa;
    }

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    @Override
    public String toString() {
        return "Korisnik{" + "id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", adresa=" + adresa + ", brojPasosa=" + brojPasosa + ", termin=" + termin + '}';
    }

}
