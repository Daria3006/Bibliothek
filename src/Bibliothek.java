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
}
