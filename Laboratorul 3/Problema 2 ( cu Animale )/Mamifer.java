package problema_2;

@SuppressWarnings("unused")
public class Mamifer extends Animal {
    protected final int nrMediuDeCopii;

    public Mamifer(int varstaAnimal, String numeAnimal, Mediu mediuAnimal, int nrMediuDeCopii) {
        super(varstaAnimal, numeAnimal, mediuAnimal);
        this.nrMediuDeCopii = nrMediuDeCopii;
    }

     int getNrMediuDeCopii() {
        return nrMediuDeCopii;
    }
}
