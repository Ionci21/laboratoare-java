package problema_2;

@SuppressWarnings("unused")
public class Papagal extends Pasare implements Abilitate {
    public Papagal(int varstaAnimal, String numeAnimal, Mediu mediuAnimal, double vitezaMedieDeZbor) {
        super(varstaAnimal, numeAnimal, mediuAnimal, vitezaMedieDeZbor);
    }

    @Override
    public String toString() {
        return "Papagalul se numeste " + numeAnimal + ", are " + varstaAnimal + " ani, traieste in mediul aerian si are o viteza medie de zbor de " + vitezaMedieDeZbor + " km/h!";
    }

    @Override
    public boolean poateZbura() {
        return true;
    }

    @Override
    public boolean sePoateCatara() {
        return true;
    }

    @Override
    public boolean poateInota() {
        return false;
    }
}
