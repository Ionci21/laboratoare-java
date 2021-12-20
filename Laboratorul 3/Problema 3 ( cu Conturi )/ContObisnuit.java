package problema_3;

@SuppressWarnings("unused")
public class ContObisnuit extends Cont implements OperatiiConturi {
    public ContObisnuit(String posesorCont, String pinCont, double soldCont) {
        super(posesorCont, pinCont, soldCont);
    }

    @Override
    public String toString() {
        return "Cont obisnuit, detinator: " + posesorCont + ", sold cont: " + String.format("%.2f", soldCont);
    }

    @Override
    public void depunereNumerer(double sumaDepusa) {
        soldCont += sumaDepusa;
    }

    @Override
    public boolean retragereNumerar(double sumaRetrasa) {
        boolean statusTranzactie = true;
        if (!verificareSoldPozitiv(sumaRetrasa)) statusTranzactie = false;
        else soldCont -= sumaRetrasa;
        return statusTranzactie;
    }

    private boolean verificareSoldPozitiv(double sumaRetrasa) {
        return (soldCont - sumaRetrasa) >= 0;
    }
}
