package problema_3;

@SuppressWarnings("unused")
class ContCD extends Cont implements OperatiiConturi {
    private boolean retragereInainteDeLuna12, dobandaPlatitaInAnulCurent;

    public ContCD(String posesorCont, String pinCont, double soldCont, boolean retragereInainteDeLuna12, boolean dobandaPlatitaInAnulCurent) {
        super(posesorCont, pinCont, soldCont);
        this.retragereInainteDeLuna12 = retragereInainteDeLuna12;
        this.dobandaPlatitaInAnulCurent = dobandaPlatitaInAnulCurent;
    }

    @Override
    public void depunereNumerer(double sumaDepusa) {
        soldCont += sumaDepusa;
    }

    @Override
    public String toString() {
        return "Cont CD, detinator: " + posesorCont + ", sold cont: " + String.format("%.2f", soldCont);
    }

    @Override
    public boolean retragereNumerar(double sumaRetrasa) {
        return retragereInainteDeLuna12 ? retragerePrimulCaz(sumaRetrasa) : retragereAlDoileaCaz(sumaRetrasa);
    }

    private boolean retragerePrimulCaz(double sumaRetrasa) {
        boolean statusTranzactie = true;
        if (!soldPozitivDupaRetragere(sumaRetrasa)) statusTranzactie = false; // daca soldul dupa retragere < 0
        else soldCont -= sumaRetrasa + 0.20 * soldCont; // daca > 0 efectuam retragerea
        return statusTranzactie; // si returnam statusul tranzactiei
    }

    private boolean soldPozitivDupaRetragere(double sumaRetrasa) {
        return (soldCont - sumaRetrasa + (0.20 * soldCont)) >= 0;
    }

    // la fel ca si mai sus
    private boolean retragereAlDoileaCaz(double sumaRetrasa) {
        boolean statusTranzactie = true;
        if (soldCont - sumaRetrasa < 0) statusTranzactie = false;
        else soldCont -= sumaRetrasa;
        return statusTranzactie;
    }

    public boolean isRetragereInainteDeLuna12() {
        return retragereInainteDeLuna12;
    }

    public void setRetragereInainteDeLuna12(boolean retragereInainteDeLuna12) {
        this.retragereInainteDeLuna12 = retragereInainteDeLuna12;
    }

    public boolean esteDobandaPlatitaPeAnulCurent() {
        return dobandaPlatitaInAnulCurent;
    }

    public void setDobandaPlatitaInAnulCurent(boolean dobandaPlatitaInAnulCurent) {
        this.dobandaPlatitaInAnulCurent = dobandaPlatitaInAnulCurent;
    }
}
