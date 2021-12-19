package problema_suplimentara_2;

@SuppressWarnings("unused")
class Ochelari {

    private String producatorOchelari, tipOchelari;
    private double pretOchelari;

    Ochelari(String producatorOchelari, String tipOchelari, double pretOchelari) {
        this.producatorOchelari = producatorOchelari;
        this.tipOchelari = tipOchelari;
        this.pretOchelari = pretOchelari;
    }

    @Override
    public String toString() {
        return "Ochelari " + this.tipOchelari + ", produsi de " + this.producatorOchelari + " si costa " + this.pretOchelari + " RON";
    }

    public String getProducatorOchelari() {
        return producatorOchelari;
    }

    public void setProducatorOchelari(String producatorOchelari) {
        this.producatorOchelari = producatorOchelari;
    }

    public String getTipOchelari() {
        return tipOchelari;
    }

    public void setTipOchelari(String tipOchelari) {
        this.tipOchelari = tipOchelari;
    }

    public double getPretOchelari() {
        return pretOchelari;
    }

    public void setPretOchelari(double pretOchelari) {
        this.pretOchelari = pretOchelari;
    }

}
