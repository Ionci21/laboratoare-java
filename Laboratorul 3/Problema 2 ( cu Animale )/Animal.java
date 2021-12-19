package problema_2;

@SuppressWarnings("unused")
abstract class Animal {
    protected int varstaAnimal;
    protected String numeAnimal;
    protected Mediu mediuAnimal;

    protected Animal(int varstaAnimal, String numeAnimal, Mediu mediuAnimal) {
        this.varstaAnimal = varstaAnimal;
        this.numeAnimal = numeAnimal;
        this.mediuAnimal = mediuAnimal;
    }
}
