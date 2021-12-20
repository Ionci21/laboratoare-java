package problema_3;

@SuppressWarnings("unused")
public class ContCuDobanda extends Cont implements OperatiiConturi {
    public ContCuDobanda(String posesorCont, String pinCont, double soldCont) {
        super(posesorCont, pinCont, soldCont);
    }

    @Override
    public String toString() {
        return "Cont cu Dobanda, detinator: " + posesorCont + ", sold cont: " + String.format("%.2f", soldCont);
    }

    @Override
    public void depunereNumerer(double sumaDepusa) {
        soldCont += sumaDepusa;
    }

    @Override
    public boolean retragereNumerar(double sumaRetrasa) {
        boolean statusRetragere = true;
        if (!verificaSoldPozitiv(sumaRetrasa)) statusRetragere = false;
        else soldCont -= sumaRetrasa;
        return statusRetragere;
    }

    private boolean verificaSoldPozitiv(double sumaRetrasa) {
        return soldCont - sumaRetrasa >= 0;
    }
}
