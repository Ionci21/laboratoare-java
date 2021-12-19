package problema_suplimentara_2;

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
        List<Ochelari> listaOchelari = creareListaOchelari();
        afisareListaOchelari(listaOchelari);
        ceiMaiIeftiniOchelari(listaOchelari);
        afisareNrOchelariPerProducator(nrOchelariPerProducator(listaOchelari));
        afisareDoarOchelariDeUnAnumeTip(listaOchelari, "de barosani");
    }

    @Contract(" -> new")
    private static @NotNull List<Ochelari> creareListaOchelari() {
        return new ArrayList<>(List.of(
                new Ochelari("Gucci", "de soare", 1499.99),
                new Ochelari("Dolce & Gabanna", "de soare", 999.99),
                new Ochelari("Optica", "de vedere", 844.99),
                new Ochelari("Gucci", "de soare", 2134.99)
        ));
    }

    private static void afisareListaOchelari(@NotNull List<Ochelari> listaCuOchelari) {
        AtomicInteger contorOchelari = new AtomicInteger(1);
        System.out.println("In lista avem urmatorii ochelari:");
        listaCuOchelari.forEach(ochelariCurenti -> System.out.println(contorOchelari.getAndIncrement() + ") " + ochelariCurenti));
    }

    private static void ceiMaiIeftiniOchelari(@NotNull List<Ochelari> listaCuOchelari) {
        Ochelari ochelariCuCelMaiMicPret = listaCuOchelari.get(0);
        for (Ochelari ochelariCurenti : listaCuOchelari)
            if (ochelariCurenti.getPretOchelari() < ochelariCuCelMaiMicPret.getPretOchelari())
                ochelariCuCelMaiMicPret = ochelariCurenti;
        System.out.println("\nCei mai ieftini ochelari din lista sunt: " + ochelariCuCelMaiMicPret);
    }

    private static @NotNull Map<String, Integer> nrOchelariPerProducator(@NotNull List<Ochelari> listaOchelari) {
        Map<String, Integer> pentruReturnat = new HashMap<>();
        for (Ochelari ochelariCurenti : listaOchelari) {
            if (!pentruReturnat.containsKey(ochelariCurenti.getProducatorOchelari()))
                pentruReturnat.put(ochelariCurenti.getProducatorOchelari(), 1);
            else
                pentruReturnat.put(ochelariCurenti.getProducatorOchelari(), pentruReturnat.get(ochelariCurenti.getProducatorOchelari()) + 1);
        }
        return pentruReturnat;
    }

    private static void afisareNrOchelariPerProducator(@NotNull Map<String, Integer> dictionarPentruAfisat) {
        System.out.println("\nNr. de ochelari / producator:");
        dictionarPentruAfisat.forEach((producatorCurent, nrOchelari) -> {
            System.out.println("Producatorul " + producatorCurent + " are " + (nrOchelari > 1 ? nrOchelari + " perechi de ochelari" : "o pereche de ochelari"));
        });
    }

    private static void afisareDoarOchelariDeUnAnumeTip(@NotNull List<Ochelari> listaCuOchelari, String tipOchelari) {
        boolean existaTipInLista = listaCuOchelari.stream().anyMatch(perecheOchelariCurenta -> perecheOchelariCurenta.getTipOchelari().equals(tipOchelari));
        if (existaTipInLista) {
            System.out.println("\nOchelarii din lista de tipul \"" + tipOchelari + "\" sunt:");
            AtomicInteger nrCurentOchelari = new AtomicInteger(1);
            listaCuOchelari.stream().filter(perecheOchelariCurenta -> perecheOchelariCurenta.getTipOchelari().equals(tipOchelari))
                    .forEach(perecheCurentaOchelari -> System.out.println(nrCurentOchelari.getAndIncrement() + ") " + perecheCurentaOchelari));

        } else System.out.println("\nNu exista nicio pereche de ochelari de tip \"" + tipOchelari + "\" in lista!");
    }

}
