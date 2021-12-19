package problema_1;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String @NotNull [] args) {
        List<Actor> listaActori = creareListaActori(); // d
        afisareListaActori(listaActori); // e
        nrActoriFaraScoala(listaActori); // f
        nrActoriNascutiInInterval(listaActori, Integer.parseInt(args[0]), Integer.parseInt(args[1])); // g
    }

    @Contract(" -> new")
    private static @NotNull List<Actor> creareListaActori() {
        return new ArrayList<>(List.of(
                new Actor("Mercescu", "Ionut", 2000),
                new Actor("Iordan", "Roberta-Ioana", 2000, "Colegiul de Actorie Sibiu"),
                new Actor("Mercescu", "Alexandra", 2006),
                new Actor("Lascu", "Natalia-Miruna", 2002, "Colegiul de Actorie Arad")
        ));
    }

    private static void afisareListaActori(@NotNull List<Actor> listaActori) {
        listaActori.forEach(System.out::println);
    }

    private static void nrActoriFaraScoala(@NotNull List<Actor> listaActori) {
        System.out.println("Nr. de actori fara scoala de actorie absolvita >> " + listaActori.stream().filter(actorCurent -> actorCurent.getNumeleScolii().equals("FARA SCOALA")).count());
    }

    // Nascuti intre 2000 si 2002 ( date introduse pe linia de comanda )
    private static void nrActoriNascutiInInterval(@NotNull List<Actor> listaActori, int limitaInferioara, int limitaSuperioara) {
        System.out.println("Nr. de actori nascuti intre " + limitaInferioara + " si " + limitaSuperioara + " este >> " +
                listaActori.stream().filter(actorCurent -> actorCurent.getAnulNasterii() >= limitaInferioara && actorCurent.getAnulNasterii() <= limitaSuperioara).count());
    }

}
