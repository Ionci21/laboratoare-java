package problema_2;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

class Main {

    public static void main(String @NotNull [] args) {
        Container obiectContainer = creareContainer();
        System.out.println("Inainte de stergere:\n" + obiectContainer);

        obiectContainer.stergeProdusDinContainer("Sampon");
        System.out.println("\nDupa stergere:\n" + obiectContainer);

        obiectContainer.modificaCantitateaProdusului(args[0], 5);
        System.out.println("\nDupa modificarea cantitatii pentru Paine din 10 in 5:\n" + obiectContainer);

        System.out.println("\nTabloul este format din urmatoarele containere:");
        Container[] tablouContainere = creareTablouContainere();
        afisareContainere(tablouContainere);
    }

    private static @NotNull Container creareContainer() {
        Container pentruReturnat = new Container(new Produs("Paine", 2.5, 10), "A");
        pentruReturnat.adaugaProdusInContainer(new Produs("Sampon", 5.0, 15));
        pentruReturnat.adaugaProdusInContainer(new Produs("Sapun Lichid", 9.0, 8));
        pentruReturnat.adaugaProdusInContainer(new Produs("Coca-Cola", 4.5, 3));
        return pentruReturnat;
    }

    @Contract(" -> new")
    private static Container @NotNull [] creareTablouContainere() {
        return new Container[]{
                creareContainer(),
                new Container(new Produs("Napolitane Joe", 4.33, 20), "B"),
                new Container(new Produs("Fanta de Portocale", 4.5, 12), "C")
        };
    }

    private static void afisareContainere(Container @NotNull [] tablouContainere) {
        for (Container containerCurent : tablouContainere) System.out.println(containerCurent);
    }

}
