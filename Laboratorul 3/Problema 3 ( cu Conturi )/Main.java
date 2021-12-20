package problema_3;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {
        var obiectBanca = new Banca("Banca ING", creareConturi(), 0.15, 0.07, false);
        System.out.println(obiectBanca);
        obiectBanca.aplicaTaxaAdministrare();
        System.out.println(obiectBanca);
        obiectBanca.aplicareDobanda();
        System.out.println(obiectBanca);
        obiectBanca.depunereNumerarInCont("Mercescu Ionut", "1234", 500.0);
        System.out.println(obiectBanca);
        obiectBanca.retragereNumerarDinCont("Mercescu Ionut", "1234", 100);
        System.out.println(obiectBanca);
    }

    @Contract(value = " -> new", pure = true)
    private static @NotNull List<Cont> creareConturi() {
        return new ArrayList<>(List.of(
                new ContObisnuit("Mercescu Ionut", "1234", 325.0),
                new ContCuDobanda("Mercescu Alexandra", "4321", 149.3),
                new ContCuVerificare("Mercescu Ionela", "1029", 825.4),
                new ContCD("Mercescu Olimpiu", "2910", 1432.8, false, false)
        ));
    }
}
