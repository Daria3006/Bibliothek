public class Buch {
    private String titel;
    private String autor;
    private int preis;
    private int anzahlSeiten;

    public Buch(String titel, String autor, int preis, int anzahlSeiten) {
        this.titel = titel;
        this.autor = autor;
        this.preis = preis;
        this.anzahlSeiten = anzahlSeiten;
    }

    public String getTitel() {
        return titel;
    }

    public String getAutor() {
        return autor;
    }

    public int getPreis() {
        return preis;
    }

    public int getAnzahlSeiten() {
        return anzahlSeiten;
    }
}
