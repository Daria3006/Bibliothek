import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(){
        List<Buch> buecher = new ArrayList<>() {};
        buecher.add(new Buch("Clean Code", "Robert Martin", 45, 464));
        buecher.add(new Buch("1984", "George Orwell", 18, 328));
        buecher.add(new Buch("Animal Farm", "George Orwell", 12, 112));
        buecher.add(new Buch("Java Basics", "Max Mueller", 35, 520));
        buecher.add(new Buch("The Hobbit", "J.R.R. Tolkien", 28, 310));

        Bibliothek bibliothek = new Bibliothek(buecher);
    }
}