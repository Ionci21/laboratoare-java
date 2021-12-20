package problema_suplimentara_1;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {
        List<XMen> listaCuSuperEroi = creareListaSuperEroi();
        afisareListaSuperEroi(listaCuSuperEroi);
        afisareDictionarCreat(nrEroiPeSuperPuteri(listaCuSuperEroi));
    }

    private static void afisareDictionarCreat(@NotNull Map<SuperPuteri, Integer> nrEroiPeSuperPuteri) {
        System.out.println("\nAvem urmatoarea situatie:");
        nrEroiPeSuperPuteri.forEach((superPutere, nrEroi) -> {
            System.out.println("Numarul de super eroi cu puterea " + superPutere + " este " + nrEroi);
        });
    }

    private static @NotNull Map<SuperPuteri, Integer> nrEroiPeSuperPuteri(@NotNull List<XMen> listaCuSuperEroi) {
        Map<SuperPuteri, Integer> pentruReturnat = new HashMap<>();
        creareDictionar(listaCuSuperEroi, pentruReturnat);
        return pentruReturnat;
    }

    private static void creareDictionar(@NotNull List<XMen> listaCuSuperEroi, Map<SuperPuteri, Integer> pentruReturnat) {
        listaCuSuperEroi.stream().flatMap(erouCurent -> erouCurent.superPuteri.stream()).forEach(putereCurenta -> {
            if (!pentruReturnat.containsKey(putereCurenta)) pentruReturnat.put(putereCurenta, 1);
            else pentruReturnat.put(putereCurenta, pentruReturnat.get(putereCurenta) + 1);
        });
    }

    private static void afisareListaSuperEroi(@NotNull List<XMen> listaCuSuperEroi) {
        AtomicInteger nrSuperErou = new AtomicInteger(1);
        System.out.println("In lista avem urmatorii super eroi:");
        listaCuSuperEroi.forEach(superErou -> System.out.println(nrSuperErou.getAndIncrement() + ") " + superErou));
    }

    @Contract(" -> new")
    private static @NotNull List<XMen> creareListaSuperEroi() {
        return new ArrayList<>(List.of(
                new Apocalipsa(new ArrayList<>(List.of(
                        SuperPuteri.INVIZIBILITATE, SuperPuteri.ARUNCA_CU_FLACARI
                )), "ApocalipsoX", 32),
                new Apocalipsa(new ArrayList<>(List.of(
                        SuperPuteri.TELEPORTARE, SuperPuteri.OPRESTE_TIMPUL, SuperPuteri.ARUNCA_CU_FLACARI
                )), "The Ruthless", 42),
                new Magneto(new ArrayList<>(List.of(
                        SuperPuteri.MAGNETISM, SuperPuteri.OPRESTE_TIMPUL, SuperPuteri.ZBOR
                )), "The Magneto", 22)
        ));
    }
}
