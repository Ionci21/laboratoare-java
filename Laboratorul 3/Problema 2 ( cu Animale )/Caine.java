package problema_2;

@SuppressWarnings("unused")
public class Caine extends Mamifer implements Abilitate {
     Caine(int varstaAnimal, String numeAnimal, Mediu mediuAnimal, int nrMediuDeCopii) {
        super(varstaAnimal, numeAnimal, mediuAnimal, nrMediuDeCopii);
    }

    @Override
    public boolean poateZbura() {
        return false;
    }

    @Override
    public String toString() {
        return "Cainele se numeste " + numeAnimal + ", are " + varstaAnimal + " ani, traieste in mediul terestru si are un numar mediu de copii la nastere de " + nrMediuDeCopii + "!";
    }

    @Override
    public boolean sePoateCatara() {
        return true;
    }

    @Override
    public boolean poateInota() {
        return true;
    }

}
