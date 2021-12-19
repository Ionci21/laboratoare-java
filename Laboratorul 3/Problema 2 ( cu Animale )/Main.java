package problema_2;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {
        List<Animal> listaAnimale = creareListaAnimale();
        afisareLista(listaAnimale);
        System.out.println("\nNumarul de animale care pot zbura este " + calculeazaNrAnimaleCeZboara(listaAnimale));
        System.out.printf("\nMedia varstei animalelor care se pot catara si nu pot inota este %.2f\n", calculeazaMediaVarstei(listaAnimale));
    }

    private static void afisareLista(@NotNull List<Animal> listaAnimale) {
        AtomicInteger nrAnimalCurent = new AtomicInteger(1);
        System.out.println("In lista sunt prezente urmatoarele animale:");
        listaAnimale.forEach(animalCurent -> System.out.println("\t" + nrAnimalCurent.getAndIncrement() + ") " + animalCurent));
    }

    @Contract(" -> new")
    private static @NotNull List<Animal> creareListaAnimale() {
        return new ArrayList<>(List.of(
                new Caine(10, "Azorel", Mediu.PAMANT, 4),
                new Pisica(9, "Tomas", Mediu.PAMANT, 3),
                new Papagal(6, "Papo", Mediu.AER, 25.4),
                new Papagal(10, "Pegasus", Mediu.AER, 43.9),
                new Soparla(10, "Soparlacescu", Mediu.ACVATIC, 5),
                new Papagal(9, "Salvadore", Mediu.AER, 43.9)
        ));
    }

    private static int calculeazaNrAnimaleCeZboara(@NotNull List<Animal> listaCuAnimale) {
        return (int) listaCuAnimale
                .stream()
                .filter(animalCurent -> animalCurent instanceof Abilitate)
                .filter(animalCurent -> ((Abilitate) animalCurent).poateZbura())
                .count();
    }

    // animalele ce se pot catara dar nu pot inota
    private static double calculeazaMediaVarstei(@NotNull List<Animal> listaCuAnimale) {
        return listaCuAnimale
                .stream()
                .filter(animalCurent -> animalCurent instanceof Abilitate)
                .filter(animalCurent -> ((Abilitate) animalCurent).sePoateCatara() && !((Abilitate) animalCurent).poateInota())
                .map(animalCurent -> animalCurent.varstaAnimal)
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0);
    }
}
