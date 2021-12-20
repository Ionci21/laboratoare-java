package problema_3;

@SuppressWarnings("unused")
public class ContCuVerificare extends Cont implements OperatiiConturi {
    public ContCuVerificare(String posesorCont, String pinCont, double soldCont) {
        super(posesorCont, pinCont, soldCont);
    }

    @Override
    public String toString() {
        return "Cont cu Verificare, detinator: " + posesorCont + ", sold cont: " + String.format("%.2f", soldCont);
    }

    @Override
    public void depunereNumerer(double sumaDepusa) {
        soldCont += sumaDepusa - 0.10;
    }

    @Override
    public boolean retragereNumerar(double sumaRetrasa) {
        boolean statusRetragere = true;
        if (!verificareSoldPozitiv(sumaRetrasa)) statusRetragere = false;
        else soldCont -= sumaRetrasa + 0.10;
        return statusRetragere;
    }

    private boolean verificareSoldPozitiv(double sumaRetrasa) {
        return (soldCont - sumaRetrasa) >= 0;
    }
}
