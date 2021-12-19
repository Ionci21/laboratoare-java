package problema_2;

public class Soparla extends Reptila implements Abilitate {
    public Soparla(int varstaAnimal, String numeAnimal, Mediu mediuAnimal, int numarulDeOua) {
        super(varstaAnimal, numeAnimal, mediuAnimal, numarulDeOua);
    }

    @Override
    public String toString() {
        return "Soparla se numeste " + numeAnimal + ", are " + varstaAnimal + " ani, traieste in mediul acvatic si depune " + numarulDeOua + " oua in medie!";
    }

    @Override
    public boolean poateZbura() {
        return false;
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
