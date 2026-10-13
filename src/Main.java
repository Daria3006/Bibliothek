import java.util.ArrayList;
import java.util.List;
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

        while(true) {
            System.out.println("1. Bucher eines Authors");
            System.out.println("2. Durchschnittliche Seitenanzahl mehrerer Bucher");
            System.out.println("3. Bucher innerhalb eines Preislimits");
            System.out.println("4. Teuerstes Buch von mehrerer Bucher");
            System.out.println("5. Bucher mit einer Mindestseitenanzahl");
            System.out.println("6. Zwei Bucher innerhalb eines Budgets");
            System.out.println("7. Programm beenden");

            System.out.print("Wahle eine Option:");

            int option = scanner.nextInt();
            scanner.nextLine();
            if (option < 1 || option > 7){
                continue;
            }

            switch(option){
                case 1:
                    System.out.print("Autor : ");
                    String autor = scanner.nextLine();
                    List<String> bucherDesAuthors = bibliothek.bucherEinesAutors(autor);
                    for (String titel : bucherDesAuthors){
                        System.out.println(titel);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}