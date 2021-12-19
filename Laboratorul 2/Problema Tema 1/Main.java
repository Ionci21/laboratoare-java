package problema_tema_1;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Main {

    public static void main(String[] args) {
        List<MagazinDeMobila> listaMagazine = creareListaMagazine();
        afisareMagazine(listaMagazine);
        magazinCuCeleMaiIeftinePreturi(listaMagazine);
        magazineCuCuvInDescriere(listaMagazine, new ArrayList<>(List.of("draguta")));
    }

    @Contract(" -> new")
    private static @NotNull List<MagazinDeMobila> creareListaMagazine() {
        return new ArrayList<>(List.of(new MagazinDeMobila("Magazin de mobila1", "Strada Magazinelor Nr. 22", List.of(new Mobila("Pat", "Un pat foarte comfortabil", "Lemn", 150.0, 50.0, 40.0, 849.99), new Mobila("Pat matrimonial", "Un pat matrimonial foarte comfortabil", "Lemn de cires", 175.0, 100.0, 45.0, 1999.99))), new MagazinDeMobila("Magazin de mobila2", "Strada Magazinelor Nr. 55 - Timisoara", List.of(new Mobila("Noptiera", "O noptiera draguta si durabila", "Lemn", 55.0, 25.5, 35.5, 324.99), new Mobila("Pat matrimonial", "Un pat matrimonial", "Lemn de nuc", 175.0, 100.0, 45.0, 1499.99)))));
    }

    public static void afisareMagazine(@NotNull List<MagazinDeMobila> listaMagazine) {
        System.out.println("In lista sunt prezente urmatoarele magazine:");
        listaMagazine.forEach(System.out::println);
    }

    private static void magazinCuCeleMaiIeftinePreturi(@NotNull List<MagazinDeMobila> listaCuMagazine) {
        List<MagazinDeMobila> listaMagazineSortateCrescator =
                listaCuMagazine.stream().sorted(
                        (primulMagazin, alDoileaMagazin) -> (int) (
                                primulMagazin.getStocMobile().stream().map(elementCurent -> elementCurent.pretMobila).mapToDouble(Double::doubleValue).average().orElse(0)
                                        - alDoileaMagazin.getStocMobile().stream().map(elementCurent -> elementCurent.pretMobila).mapToDouble(Double::doubleValue).average().orElse(0)
                        )
                ).toList();
        System.out.println("\nMagazinul cu cele mai ieftine preturi este:\n" + listaMagazineSortateCrescator.get(0));
    }

    private static void magazineCuCuvInDescriere(@NotNull List<MagazinDeMobila> listaCuMagazine, List<String> cuvinteDeCautat) {
        int nrAsemanari = listaCuMagazine.stream().mapToInt(magazinCurent -> (int) magazinCurent.getStocMobile().stream().filter(mobilaCurenta -> cuvinteDeCautat.stream().anyMatch(cuvantCurent -> mobilaCurenta.getDescriereMobila().contains(cuvantCurent))).count()).sum();
        System.out.println("\nAvem " + (nrAsemanari > 0 ? nrAsemanari > 1 ? nrAsemanari + " mobile ce contin cuvinte din lista data!" : "o mobila ce contine cuvinte din lista data" : "nu avem mobile ce contin cuvinte din lista data"));
    }

}
