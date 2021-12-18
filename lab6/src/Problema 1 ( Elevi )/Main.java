package prima_problema;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws ExceptiiElev {
        // a), b) si c)
        List<Elev> listaElevi = creareLista();
        listaElevi.forEach(System.out::println);

        // d) - creare functii ce calculeaza media la o anumita materie, media generala a elevului si permite adaugarea de note noi
        System.out.printf("\nMedia elevului %s la materia %s este %.2f!\n", listaElevi.get(0).getNumeElev(), "Matematica", listaElevi.get(0).calculeazaMedieMaterie("Matematica"));
        System.out.printf("Media generala a elevului %s este %.2f!\n", listaElevi.get(0).getNumeElev(), listaElevi.get(0).calculeazaMediaGenerala());
        listaElevi.get(0).adaugaNota("Matematica", 5);

        // e) - sortare lista in functie de media generala
        System.out.println("\nLista dupa sortare crescatoare dupa medie:");
        sortareLista(listaElevi);

        // f) - verifica daa toti elevii au cel putin o nota la fiecare materie si daca au ii afiseaza, daca nu, nu-i afiseaza
        System.out.println("\nElevii cu cel putin o nota la fiecare materie:");
        listaElevi.get(0).getCarnetDeNote().get("Geografie").remove(0); // nu ar trebui sa afiseze Mercescu Ionut
        eleviCuCelPutinONota(listaElevi);

        // g) - gaseste elevii cu media generala maxima si minima si-i afiseaza
        afisareEleviCuMediaGenMaxSiMin(listaElevi);

        // h) - elevi care mai au nevoie de note pentru a se calcula media
        System.out.println("\nElevii care mai au nevoie de o nota ca sa incheie media la o anumita materie:");
        eleviCareMaiAuNevoieDeNote(listaElevi);

        // i) - afisare elevi pe clase
        System.out.println();
        afisareEleviPeClase(listaEleviPeClase(listaElevi));

        // j) - afisare primii 3 elevi pe clase dupa media generala
        System.out.println();
        primiiTreiEleviPeClase(listaEleviPeClase(listaElevi));

        // k) -
        raportDeNota("Limba si Literatura Romana", listaElevi);
    }

    /**
     * Creaza "carnetul de note" al fiecarui elev cu note random
     * @return dictionarul ce contine "carnetul de note"
     */
    @Contract(" -> new")
    private static @NotNull Map<String, List<Integer>> creareCarnetElev() {
        return new HashMap<>(Map.of(
                "Matematica", creareListaNote(3),
                "Limba si Literatura Romana", creareListaNote(3),
                "Biologie", creareListaNote(2),
                "Geografie", creareListaNote(1)
        ));
    }

    /**
     * Creaza o lista de o anumita dimensiune cu numere random intre 1 si 10
     * @param nrNote dimensiunea listei
     * @return lista cu notele random
     */
    private static List<Integer> creareListaNote(int nrNote) {
        return IntStream.range(0, nrNote).mapToObj(i -> new Random().nextInt(1, 11)).collect(Collectors.toList());
    }

    /**
     * Creaza lista de elevi
     * @return lista de elevi
     * @throws ExceptiiElev in caz ca notele si clasa nu corespund intervalelor predefinite
     */
    @Contract(" -> new")
    private static @NotNull List<Elev> creareLista() throws ExceptiiElev {
        return new ArrayList<>(List.of(
                new Elev("Mercescu Ionut", 12, creareCarnetElev()),
                new Elev("Iordan Roberta-Ioana", 12, creareCarnetElev()),
                new Elev("Maciovan Razvan-Alexandru", 12, creareCarnetElev()),
                new Elev("Lascu Miruna-Natalia", 11, creareCarnetElev()),
                new Elev("Ranisav Goran", 11, creareCarnetElev())
        ));
    }

    /**
     * Sorteaza crescator lista de elevi
     * @param listaElevi lista cu elevi ce urmeaza sa fie sortata
     */
    private static void sortareLista(@NotNull List<Elev> listaElevi) {
        listaElevi.stream().sorted((primulElev, alDoileaElev) -> (int) (primulElev.calculeazaMediaGenerala() - alDoileaElev.calculeazaMediaGenerala())).forEach(System.out::println);
    }

    /**
     * Parcurge lista de elevi si ii afiseaza pe cei cu minim o nota la fiecare materie
     * @param listaElevi lista de levi unde cautam ( List<Elev> )
     */
    private static void eleviCuCelPutinONota(@NotNull List<Elev> listaElevi) {
        listaElevi.forEach(elevCurent -> {
            if (elevCurent.getCarnetDeNote().values().stream().allMatch(listaNote -> listaNote.size() >= 1))
                System.out.println(elevCurent);
        });
    }

    /**
     * Cauta elevul cu cea mai mica medie si cel cu cea mai mare medie si-i afiseaza
     * @param listaElevi lista unde cautam elevii ( List<Elev> )
     */
    private static void afisareEleviCuMediaGenMaxSiMin(@NotNull List<Elev> listaElevi) {
        double mediePentruComparatLaMaxim = 0, mediePentruComparatLaMinim = 10, mediaCurenta = 0;
        Elev elevulCuCeaMaiMareMedie = null, elevulCuCeaMaiMicaMedie = null;
        for (Elev elevCurent : listaElevi) {
            mediaCurenta = elevCurent.calculeazaMediaGenerala();
            if (mediaCurenta > mediePentruComparatLaMaxim) {
                mediePentruComparatLaMaxim = mediaCurenta;
                elevulCuCeaMaiMareMedie = elevCurent;
            }
            if (mediaCurenta < mediePentruComparatLaMinim) {
                mediePentruComparatLaMinim = mediaCurenta;
                elevulCuCeaMaiMicaMedie = elevCurent;
            }
        }
        System.out.printf("\nElevul cu cea mai mica medie, %.2f, este %s\niar cel cu cea mai mare medie, %.2f este %s!\n", mediePentruComparatLaMinim, elevulCuCeaMaiMicaMedie, mediePentruComparatLaMaxim, elevulCuCeaMaiMareMedie);
    }

    public static void eleviCareMaiAuNevoieDeNote(@NotNull List<Elev> listaElevi) {
        listaElevi.forEach(elevCurent -> {
            if (elevCurent.getCarnetDeNote().values().stream().anyMatch(listaNote -> listaNote.size() <= 1))
                System.out.println(elevCurent);
        });
    }

    private static Set<Integer> creareSetClase(@NotNull List<Elev> listaElevi) {
        return listaElevi.stream().map(Elev::getClasaElevului).collect(Collectors.toSet());
    }

    private static @NotNull Map<Integer, List<Elev>> listaEleviPeClase(List<Elev> listaElevi) {
        Set<Integer> setClase = creareSetClase(listaElevi);
        Map<Integer, List<Elev>> pentruReturnat = new HashMap<>();
        setClase.forEach(clasaCurenta -> pentruReturnat.put(clasaCurenta, new ArrayList<>()));
        listaElevi.stream().filter(elevCurent -> pentruReturnat.containsKey(elevCurent.getClasaElevului())).forEachOrdered(elevCurent -> {
            List<Elev> listaEleviDinDictionar = pentruReturnat.get(elevCurent.getClasaElevului());
            listaEleviDinDictionar.add(elevCurent);
        });
        return pentruReturnat;
    }

    private static void afisareEleviPeClase(@NotNull Map<Integer, List<Elev>> dictionarEleviPeClase) {
        dictionarEleviPeClase.forEach((clasaCurenta, listaElevi) -> {
            System.out.println("Elevii din clasa a " + clasaCurenta + " sunt:");
            listaElevi.forEach(System.out::println);
        });
    }

    private static void primiiTreiEleviPeClase(@NotNull Map<Integer, List<Elev>> dictionarEleviPeClase) {
        dictionarEleviPeClase.forEach((clasaCurenta, listaElevi) -> {
            List<Elev> listaProvizorie = listaElevi.stream().sorted((primulElev, alDoileaElev) -> (int) (alDoileaElev.calculeazaMediaGenerala() - primulElev.calculeazaMediaGenerala())).collect(Collectors.toList());
            listaElevi.clear();
            listaElevi.addAll(listaProvizorie);
        });
        dictionarEleviPeClase.forEach((clasaCurenta, listaElevi) -> {
            System.out.println("Primii 3 elevi sortati dupa mediea generala din clasa a " + clasaCurenta + " sunt:");
            if (listaElevi.size() >= 3) IntStream.range(0, 3).mapToObj(i -> listaElevi.get(i) + " cu media generala de " + listaElevi.get(i).calculeazaMediaGenerala()).forEachOrdered(System.out::println);
            else listaElevi.forEach(elevCurent -> System.out.println(elevCurent + " cu media generala de " + elevCurent.calculeazaMediaGenerala()));

        });
    }

    private static void raportDeNota(String numeleMateriei, @NotNull List<Elev> listaElevi) {
        Map<Integer, Integer> dictionarEleviCuNota = new TreeMap<>(Collections.reverseOrder());
        listaElevi.stream()
                .filter(elevCurent -> elevCurent.getCarnetDeNote().containsKey(numeleMateriei))
                .map(elevCurent -> new HashSet<>(elevCurent.getCarnetDeNote().get(numeleMateriei)))
                .flatMap(Collection::stream)
                .forEach(notaCurenta -> {
            if (!dictionarEleviCuNota.containsKey(notaCurenta)) dictionarEleviCuNota.put(notaCurenta, 1);
            else dictionarEleviCuNota.put(notaCurenta, dictionarEleviCuNota.get(notaCurenta) + 1);
        });
        System.out.println("\nLa materia " + numeleMateriei + " avem urmatoarea situatie:");
        dictionarEleviCuNota.forEach((notaCurenta, nrEleviCuNotaRespectiva) -> {
            System.out.println("Numarul de elevi cu nota " + notaCurenta + " este " + nrEleviCuNotaRespectiva + "!");
        });
    }

}
