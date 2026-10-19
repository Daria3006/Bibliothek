import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        List<Buch> buecher = new ArrayList<>() {};
        buecher.add(new Buch("Clean Code", "Robert Martin", 45, 464));
        buecher.add(new Buch("1984", "George Orwell", 18, 328));
        buecher.add(new Buch("Animal Farm", "George Orwell", 12, 112));
        buecher.add(new Buch("Java Basics", "Max Muller", 35, 520));
        buecher.add(new Buch("The Hobbit", "J.R.R. Tolkien", 28, 310));

        Bibliothek bibliothek = new Bibliothek(buecher);


        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while(running) {
            System.out.println("1. Bucher eines Authors");
            System.out.println("2. Durchschnittliche Seitenanzahl mehrerer Bucher");
            System.out.println("3. Bucher innerhalb eines Preislimits");
            System.out.println("4. Teuerstes Buch von mehrerer Bucher");
            System.out.println("5. Bucher mit einer Mindestseitenanzahl");
            System.out.println("6. Zwei Bucher innerhalb eines Budgets");
            System.out.println("7. Programm beenden");

            System.out.print("Wahle eine Option : ");

            int option;
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
            }
            else{
                System.out.println();
                System.out.println("Invalide Option!");
                System.out.println();
                scanner.next();
                continue;
            }

            scanner.nextLine();
            if (option < 1 || option > 7) {
                System.out.println();
                System.out.println("Invalide Option!");
                System.out.println();
                continue;
            }

            switch (option) {
                case 1: {
                    List<String> autoren = bibliothek.alleAutoren();
                    String autor;
                    while (true) {
                        System.out.print("Autor : ");
                        autor = scanner.nextLine();
                        if (autoren.contains(autor))
                            break;
                        else{
                            System.out.println("Invalider Name!");
                        }
                    }

                    System.out.println();

                    List<String> bucherDesAuthors = bibliothek.bucherEinesAutors(autor);
                    for (String titel : bucherDesAuthors) {
                        System.out.println(titel);
                    }
                    break;
                }
                case 2: {
                    List<String> titelListe = listeLesen(bibliothek);

                    System.out.println();
                    double durchschnitt = bibliothek.durchschnittlicheSeitenanzhal(titelListe);
                    System.out.println(String.format("%.2f", durchschnitt));
                    break;
                }
                case 3: {
                    List<String> titelListe = listeLesen(bibliothek);

                    int preis;
                    while (true) {
                        System.out.print("Maximaler Preis: ");
                        if (scanner.hasNextInt()){
                            preis = scanner.nextInt();
                            break;
                        }
                        else{
                            System.out.println();
                            System.out.println("Invalider Input!");
                            System.out.println();
                        }
                    }

                    System.out.println();
                    titelListe = bibliothek.bucherInnerhalbPreislimit(titelListe, preis);
                    for (String titel : titelListe){
                        System.out.println(titel);
                    }
                    break;
                }
                case 4: {
                    List<String> titelListe = listeLesen(bibliothek);

                    System.out.println();
                    String antwort = bibliothek.teuersteBuch(titelListe);
                    System.out.println(antwort);
                    break;
                }

                case 5: {
                    int seitenAnzahl;
                    while (true) {
                        System.out.print("Mindest Seitenanzahl: ");
                        if (scanner.hasNextInt()){
                            seitenAnzahl = scanner.nextInt();
                            break;
                        }
                        else{
                            System.out.println();
                            System.out.println("Invalider Input!");
                            System.out.println();
                        }
                    }

                    System.out.println();
                    List<String> titelListe = bibliothek.bucherMitMindestSeitenanzahl(seitenAnzahl);
                    for (String titel : titelListe){
                        System.out.println(titel);
                    }
                    break;
                }
                case 6: {
                    List<String> titelListe = listeLesen(bibliothek);

                    int budget;
                    while (true) {
                        System.out.print("Budget: ");
                        if (scanner.hasNextInt()){
                            budget = scanner.nextInt();
                            break;
                        }
                        else{
                            System.out.println();
                            System.out.println("Invalider Input!");
                            System.out.println();
                        }
                    }

                    String antwort = bibliothek.zweiBucherInnerhalbBudget(titelListe, budget);
                    System.out.println(antwort);
                }
                case 7: {
                    running = false;
                    break;
                }
                default: {
                    break;
                }
            }
            System.out.println();
        }
    }

    public static List<String> listeLesen(Bibliothek bibliothek){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Fuge Bucher ein (beende mit `.`)");
        List<String> titelListe = new ArrayList<>();
        List<String> existierendeTitel = bibliothek.alleTitel();
        while (true) {
            String titel = scanner.nextLine();
            if (!existierendeTitel.contains(titel) && !Objects.equals(titel, ".")) {
                System.out.println("Invalider Titel!");
                continue;
            }
            if (!Objects.equals(titel, ".")) {
                titelListe.add(titel);
            } else {
                break;
            }

        }
        return titelListe;
    }
}