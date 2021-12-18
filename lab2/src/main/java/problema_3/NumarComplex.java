package problema_3;

@SuppressWarnings("unused")
class NumarComplex {

    private double parteaReala, parteaImaginara;

    NumarComplex(double parteaReala, double parteaImaginara) {
        this.parteaReala = parteaReala;
        this.parteaImaginara = parteaImaginara;
    }

    double modulNrComplex() {
        return Math.sqrt(this.parteaReala * this.parteaReala + this.parteaImaginara * this.parteaImaginara);
    }

    @Override
    public String toString() {
        return "z=" + this.parteaReala + (parteaImaginara >= 0 ? "+" + parteaImaginara + "i" : parteaImaginara + "i");
    }

    public double getParteaReala() {
        return parteaReala;
    }

    public void setParteaReala(double parteaReala) {
        this.parteaReala = parteaReala;
    }

    public double getParteaImaginara() {
        return parteaImaginara;
    }

    public void setParteaImaginara(double parteaImaginara) {
        this.parteaImaginara = parteaImaginara;
    }

}
