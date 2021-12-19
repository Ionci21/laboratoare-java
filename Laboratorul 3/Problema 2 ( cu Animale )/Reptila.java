package problema_2;

@SuppressWarnings("unused")
public class Reptila extends Animal {
    protected final int numarulDeOua;

    public Reptila(int varstaAnimal, String numeAnimal, Mediu mediuAnimal, int numarulDeOua) {
        super(varstaAnimal, numeAnimal, mediuAnimal);
        this.numarulDeOua = numarulDeOua;
    }

    public int getNumarulDeOua() {
        return numarulDeOua;
    }
}
