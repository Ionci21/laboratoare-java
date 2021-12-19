package problema_2;

@SuppressWarnings("unused")
class Produs {
    private String numeProdus;
    private double pretProdus;
    private int cantitateProdusl;

    Produs() {

    }

    Produs(String numeProdus, double pretProdus, int cantitateProdusl) {
        this.numeProdus = numeProdus;
        this.pretProdus = pretProdus;
        this.cantitateProdusl = cantitateProdusl;
    }

    @Override
    public String toString() {
        return "Numele produsului " + this.numeProdus + ", cantitate: " + this.cantitateProdusl + " la pretul unitat de " + this.pretProdus + " RON";
    }

    String getNumeProdus() {
        return numeProdus;
    }

    void setNumeProdus(String numeProdus) {
        this.numeProdus = numeProdus;
    }

    double getPretProdus() {
        return pretProdus;
    }

    void setPretProdus(double pretProdus) {
        this.pretProdus = pretProdus;
    }

    int getCantitateProdusl() {
        return cantitateProdusl;
    }

    void setCantitateProdusl(int cantitateProdusl) {
        this.cantitateProdusl = cantitateProdusl;
    }

}
