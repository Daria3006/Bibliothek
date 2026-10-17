import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bibliothek {
    private List<Buch> bucher;

    public Bibliothek(List<Buch> bucher) {
        this.bucher = bucher;
    }

    public List<String> bucherEinesAutors(String autor){
        List<String> bucherDesAutors = new ArrayList<>();
        for (Buch buch : bucher){
            if (Objects.equals(buch.getAutor(), autor)) {
                bucherDesAutors.add(buch.getTitel());
            }
        }
        return bucherDesAutors;
    }

    public double durchschnittlicheSeitenanzhal(List<String> titelListe){
        if (titelListe.isEmpty())
            return 0;
        int summe = 0;
        for (String titel : titelListe){
            for (Buch buch : bucher){
                if (Objects.equals(buch.getTitel(), titel)){
                    summe += buch.getAnzahlSeiten();
                }
            }
        }
        return (double) summe / titelListe.size();
    }

    public List<String> bucherInnerhalbPreislimit(int preis){
        List<String> titelListe = new ArrayList<>();
        for (Buch buch : bucher){
            if (buch.getPreis() <= preis){
                titelListe.add(buch.getTitel());
            }
        }
        return titelListe;
    }

    public String teuersteBuch(List<String> titelListe){
        if (titelListe.isEmpty())
            return "0";
        String max_titel = "";
        int max_preis = 0;
        for (String titel : titelListe){
            for (Buch buch : bucher){
                if (Objects.equals(buch.getTitel(), titel) && buch.getPreis() > max_preis){
                    max_titel = buch.getTitel();
                    max_preis = buch.getPreis();
                }
            }
        }
        return max_titel + " (" + max_preis + " Euro)";
    }

    public List<String> bucherMitMindestSeitenanzahl(int seitenAnzahl){
        List<String> titelListe = new ArrayList<>();
        for (Buch buch : bucher){
            if (buch.getAnzahlSeiten() > seitenAnzahl){
                titelListe.add(buch.getTitel());
            }
        }
        return titelListe;
    }
}
