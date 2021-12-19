package problema_2;

@SuppressWarnings("unused")
public class Pasare extends Animal {
    protected final double vitezaMedieDeZbor;

    public Pasare(int varstaAnimal, String numeAnimal, Mediu mediuAnimal, double vitezaMedieDeZbor) {
        super(varstaAnimal, numeAnimal, mediuAnimal);
        this.vitezaMedieDeZbor = vitezaMedieDeZbor;
    }

    public double getVitezaMedieDeZbor() {
        return vitezaMedieDeZbor;
    }
}
