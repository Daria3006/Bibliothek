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

    public List<String> bucherInnerhalbPreislimit(List<String> titelListe, int preis){
        for (Buch buch : bucher){
            if (titelListe.contains(buch.getTitel()) && buch.getPreis() > preis) {
                titelListe.remove(buch.getTitel());
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

    public String zweiBucherInnerhalbBudget(List<String> titelListe, int budget){
        int max_preis = 0;
        List<Buch> zweiBucher = new ArrayList<>();
        for (Buch buch1 : bucher){
            if (titelListe.contains(buch1.getTitel())){
                for (Buch buch2 : bucher){
                    if (buch1 != buch2 && titelListe.contains(buch2.getTitel())){
                        int summe = buch1.getPreis() + buch2.getPreis();
                        if (summe <= budget){
                            if (summe > max_preis){
                                max_preis = summe;
                                zweiBucher.clear();
                                zweiBucher.add(buch1);
                                zweiBucher.add(buch2);
                            }
                            else if (summe == max_preis){
                                if (zweiBucher.get(0).getAnzahlSeiten() + zweiBucher.get(1).getAnzahlSeiten() < buch1.getAnzahlSeiten() + buch2.getAnzahlSeiten()){
                                    zweiBucher.clear();
                                    zweiBucher.add(buch1);
                                    zweiBucher.add(buch2);
                                }
                            }
                        }
                    }
                }
            }
        }
        return zweiBucher.get(0).getTitel() + " + " + zweiBucher.get(1).getTitel() + "\n" + "Gesamtpreis: " + max_preis + " Euro";
    }
}
