package problema_suplimentara_1;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class Main {

    public static void main(String[] args) {
        int constantaCuCareMultiplicam = 4;
        Vector primulVector = new Vector(new ArrayList<>(List.of(1, 2, 3, 4)));
        System.out.println(primulVector);
        multiplicaVector(primulVector, constantaCuCareMultiplicam);
        System.out.println("Dupa multiplicarea vectorului cu " + constantaCuCareMultiplicam + " avem urmatorul rezultat: " + primulVector);
        Vector alDoileaVector = new Vector(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7)));
        System.out.println("Rezultatul adunarii vectorilor " + primulVector + " si " + alDoileaVector + " este " + adunareADoiVector(primulVector, alDoileaVector));
        System.out.println(afisareMatrice(creareMatrice(2, 3, new Vector(new ArrayList<>(List.of(1, 2, 4, 6, 6, 3))))));
        List<Vector> listaCuVectori = new ArrayList<>(List.of(primulVector, alDoileaVector, new Vector(new ArrayList<>(List.of(1, 2, 4, 6, 6, 3)))));
        sortareSiAfisareTablouVectori(listaCuVectori);
    }

    private static void multiplicaVector(@NotNull Vector obiectVector, int constantaCuCareMultiplicam) {
        obiectVector.setElementeDinVector(obiectVector.getElementeDinVector().stream().map(elementCurent -> elementCurent * constantaCuCareMultiplicam).collect(Collectors.toList()));
    }

    @Contract("_, _ -> new")
    private static @NotNull Vector adunareADoiVector(@NotNull Vector primulVector, @NotNull Vector alDoileaVector) {
        Vector vectorCuDimensiuneaMica, vectorCuDimensiuneaMare;
        int dimensiuneaVectoruluiMic, dimensiuneaVectoruluiMare;
        List<Integer> elementelePrimuluiVector, elementeleCeluiDeAlDoileaVector, rezultatulAdunariiVectorilor;

        // Aflam care este vectorul cu dimensiunea mai mica si care este vectorul cu dimensiunea mai mare
        if (primulVector.getElementeDinVector().size() < alDoileaVector.getElementeDinVector().size()) {
            vectorCuDimensiuneaMica = primulVector;
            vectorCuDimensiuneaMare = alDoileaVector;
        } else {
            vectorCuDimensiuneaMica = alDoileaVector;
            vectorCuDimensiuneaMare = primulVector;
        }

        // Dupa ce am aflat salvam dimensiunile fiecaruia in 2 variabile pentru a le putea folosi mai usor
        dimensiuneaVectoruluiMic = vectorCuDimensiuneaMica.getElementeDinVector().size();
        dimensiuneaVectoruluiMare = vectorCuDimensiuneaMare.getElementeDinVector().size();

        // Mai apoi preluam elementele fiecarui vector in cate o Lista si cream o noua Lista pe care o vom popula cu suma elementelor celor doi Vectori!
        elementelePrimuluiVector = primulVector.getElementeDinVector();
        elementeleCeluiDeAlDoileaVector = alDoileaVector.getElementeDinVector();
        rezultatulAdunariiVectorilor = new ArrayList<>();

        // Adunarea propriu-zisa, prima data adunam elementele celor doi vectori pana atingem ultimul element din Vector-ul cu dimensiunea mai mica iar mai apoi adaugam restul
        // de elemente ramase din Vectorul mai mare
        // daca am avea
        // v1 = [1,2,3,4]
        // v2 = [1,2,3,4,5,6,7]
        // v1 + v2 = [2,4,6,8,5,6,7] ( primul for responsabil pentru elementele de pe pozitiile 0-3 iar al doilea for responsabil pentru elementele ramase! )
        for (int i = 0; i < dimensiuneaVectoruluiMic; i++)
            rezultatulAdunariiVectorilor.add(elementelePrimuluiVector.get(i) + elementeleCeluiDeAlDoileaVector.get(i));
        for (int i = dimensiuneaVectoruluiMic; i < dimensiuneaVectoruluiMare; i++)
            rezultatulAdunariiVectorilor.add(vectorCuDimensiuneaMare.getElementeDinVector().get(i));

        // iar la final returnam un nou Vector cu suma elementelor celor 2
        return new Vector(rezultatulAdunariiVectorilor);
    }

    private static int @NotNull [] @NotNull [] creareMatrice(int nrLinii, int nrColoane, @NotNull Vector vectorPrimit) {
        List<Integer> listaFaraDuplicate = creareListaFaraDuplicate(vectorPrimit);
        if (listaFaraDuplicate.size() % 2 == 0) {
            System.out.println(listaFaraDuplicate);
            int[][] matriceFormataDinVector = new int[nrLinii][nrColoane];
            int k = 0;
            for (int i = 0; i < nrLinii; i++)
                for (int j = 0; j < nrColoane; j++)
                    matriceFormataDinVector[i][j] = listaFaraDuplicate.get(k++);
            return matriceFormataDinVector;
        }
        return new int[0][];
    }

    private static @NotNull List<Integer> creareListaFaraDuplicate(@NotNull Vector vectorPrimit) {
        List<Integer> pentruReturnat = new ArrayList<>();
        vectorPrimit.getElementeDinVector().stream().filter(nrCurent -> !pentruReturnat.contains(nrCurent)).forEach(pentruReturnat::add);
        return pentruReturnat;
    }

    private static @NotNull String afisareMatrice(int @NotNull [] @NotNull [] matricePrimita) {
        if (matricePrimita.length == 0)
            return """
                    Eroare in afisarea matricii! ( pentru a crea o matrice vectorul trebuie sa contina un numar par de elemente! )
                    ( inclusiv dupa eliminarea duplicatelor!!! )
                    de exemplu v = [1,2,2,4,5] ( se poate face o matrice din el deoarece dupa eliminarea elementelor duplicate ramanem cu [1,2,4,5] - nr. par de elemente
                    dar v = [1,2,2,4] ( nr. par de elemente initial dar dupa eliminarea duplicatelor avem [1,2,4] - nu se mai respecta a doua conditie deci nu putem crea o matrice din acest vector!""";
        StringBuilder pentruReturnat = new StringBuilder();
        Arrays.stream(matricePrimita).forEach(linieCurenta -> {
            pentruReturnat.append("|");
            Arrays.stream(linieCurenta).forEach(elementCurent -> pentruReturnat.append(elementCurent).append(","));
            pentruReturnat.deleteCharAt(pentruReturnat.length() - 1).append("|").append("\n");
        });
        return pentruReturnat.deleteCharAt(pentruReturnat.length() - 1).toString();
    }

    private static void sortareSiAfisareTablouVectori(@NotNull List<Vector> listaCuVectori) {
        System.out.println("Inainte de sortare:");
        listaCuVectori.forEach(System.out::println);
        System.out.println("Dupa sortare:");
        listaCuVectori.stream().sorted((primulVector, alDoileaVector) -> (int) (primulVector.mediaElementelorDinLista() - alDoileaVector.mediaElementelorDinLista())).forEach(System.out::println);
    }

}
