package problema_1;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        List<Figura> listaFiguri = creareListaFiguri();
        afisareLista(listaFiguri);
        System.out.println("\nSuma ariilor dreptunghiurilor din lista este: " + sumaAriilorDreptunghiurilor(listaFiguri));
        listaFiguri.add(new Trapez(true, 5, 10, 5, new ArrayList<>(List.of(5.0f, 5.0f, 4.5f, 5.5f))));
        System.out.println("\nDupa adaugarea Trapezului in Lista:");
        afisareLista(listaFiguri);
        System.out.println("\nDupa ce stergem figurile din cerc:");
        stergeCercuriDinLista(listaFiguri);
        afisareLista(listaFiguri);
    }

    @Contract(" -> new")
    private static @NotNull List<Figura> creareListaFiguri() {
        return new ArrayList<>(List.of(
                new Dreptunghi(true, 5, 10),
                new Dreptunghi(true, 10, 10),
                new Cerc(true, 5),
                new Dreptunghi(false, 2, 3),
                new Cerc(false, 10),
                new Cerc(true, 15)
        ));
    }

    private static void afisareLista(@NotNull List<Figura> listaFiguri) {
        AtomicInteger nrFiguraCurenta = new AtomicInteger(1);
        System.out.println("In lista se afla urmatoarele figuri:");
        listaFiguri.forEach(figuraCurenta -> System.out.println("\t" + nrFiguraCurenta.getAndIncrement() + ") " + figuraCurenta));
    }

    private static float sumaAriilorDreptunghiurilor(@NotNull List<Figura> listaFiguri) {
        return (float) listaFiguri.stream().filter(figuraCurenta -> figuraCurenta instanceof Dreptunghi).map(Figura::calculeazaAria).mapToDouble(Float::doubleValue).sum();
    }

    private static void stergeCercuriDinLista(@NotNull List<Figura> listaFiguri) {
        listaFiguri.removeIf(figuraCurenta -> figuraCurenta instanceof Cerc);
    }
}
