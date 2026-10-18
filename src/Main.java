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

            int option = scanner.nextInt();
            scanner.nextLine();
            if (option < 1 || option > 7) {
                continue;
            }

            switch (option) {
                case 1: {
                    System.out.print("Autor : ");
                    String autor = scanner.nextLine();
                    System.out.println();

                    List<String> bucherDesAuthors = bibliothek.bucherEinesAutors(autor);
                    for (String titel : bucherDesAuthors) {
                        System.out.println(titel);
                    }
                    break;
                }
                case 2: {
                    List<String> titelListe = listeLesen();

                    System.out.println();
                    double durchschnitt = bibliothek.durchschnittlicheSeitenanzhal(titelListe);
                    System.out.println(String.format("%.2f", durchschnitt));
                    break;
                }
                case 3: {
                    List<String> titelListe = listeLesen();

                    System.out.print("Maximaler Preis: ");
                    int preis = Integer.parseInt(scanner.nextLine());

                    System.out.println();
                    titelListe = bibliothek.bucherInnerhalbPreislimit(titelListe, preis);
                    for (String titel : titelListe){
                        System.out.println(titel);
                    }
                    break;
                }
                case 4: {
                    List<String> titelListe = listeLesen();

                    System.out.println();
                    String antwort = bibliothek.teuersteBuch(titelListe);
                    System.out.println(antwort);
                    break;
                }

                case 5: {
                    System.out.print("Mindestanzahl: ");
                    int seitenAnzahl = Integer.parseInt(scanner.nextLine());

                    System.out.println();
                    List<String> titelListe = bibliothek.bucherMitMindestSeitenanzahl(seitenAnzahl);
                    for (String titel : titelListe){
                        System.out.println(titel);
                    }
                    break;
                }
                case 6: {
                    List<String> titelListe = listeLesen();

                    System.out.print("Budget: ");
                    int budget = Integer.parseInt(scanner.nextLine());

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

    public static List<String> listeLesen(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Fuge Bucher ein (beende mit `.`)");
        List<String> titelListe = new ArrayList<>();
        while (true) {
            String titel = scanner.nextLine();
            if (!Objects.equals(titel, ".")) {
                titelListe.add(titel);
            } else {
                break;
            }
        }
        return titelListe;
    }
}