package problema_3;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

class Main {

    public static void main(String[] args) {
        NumarComplex numarComplex = new NumarComplex(6,-8);
        System.out.println("\"" + numarComplex + "\"");
        System.out.println("Partea reala a numarului complex \"" + numarComplex + "\" este \"" + numarComplex.modulNrComplex() + "\"");
        NumarComplex alDoileaNumarComplex = new NumarComplex(6, 10);
        System.out.println("Suma nr. complexe \"" + numarComplex + "\" si \"" + alDoileaNumarComplex + "\" este \"" + sumaNumereComplexe(numarComplex, alDoileaNumarComplex) + "\"");
        System.out.println("Produsul nr. complexe \"" + numarComplex + "\" si \"" + alDoileaNumarComplex + "\" este \"" + produsNumereComplexe(numarComplex, alDoileaNumarComplex) + "\"");

    }

    @Contract("_, _ -> new")
    private static @NotNull NumarComplex sumaNumereComplexe(@NotNull NumarComplex primulNumar, @NotNull NumarComplex alDoileaNumar) {
        return new NumarComplex(primulNumar.getParteaReala() + alDoileaNumar.getParteaReala(), primulNumar.getParteaImaginara() + alDoileaNumar.getParteaImaginara());
    }

    @Contract("_, _ -> new")
    private static @NotNull NumarComplex produsNumereComplexe(@NotNull NumarComplex primulNumar, @NotNull NumarComplex alDoileaNumar) {
        double parteaReala = primulNumar.getParteaReala() * alDoileaNumar.getParteaReala() - primulNumar.getParteaImaginara() * alDoileaNumar.getParteaImaginara();
        double parteaImaginara = primulNumar.getParteaReala() * alDoileaNumar.getParteaImaginara() + primulNumar.getParteaImaginara() * alDoileaNumar.getParteaReala();
        return new NumarComplex(parteaReala, parteaImaginara);
    }

}
