package problema_1;

@SuppressWarnings("unused")
class Actor {

    private String numeActor, prenumeActor;
    int anulNasterii;
    String numeleScolii;

    Actor() {
    }

    Actor(String numeActor, String prenumeActor, int anulNasterii) {
        this.numeActor = numeActor;
        this.prenumeActor = prenumeActor;
        this.anulNasterii = anulNasterii;
        this.numeleScolii = "FARA SCOALA";
    }

    Actor(String numeActor, String prenumeActor, int anulNasterii, String numeleScolii) {
        this.numeActor = numeActor;
        this.prenumeActor = prenumeActor;
        this.anulNasterii = anulNasterii;
        this.numeleScolii = numeleScolii;
    }

    @Override
    public String toString() {
        return "Numele actorului este " + this.numeActor + " " + this.prenumeActor + ", nascut in anul " + this.anulNasterii +
                (this.numeleScolii.equals("FARA SCOALA") ? " si nu are absolvita scoala de actorie" : " si a absolvit scoala de actorie " + this.numeleScolii);
    }

    String getNumeActor() {
        return numeActor;
    }

    void setNumeActor(String numeActor) {
        this.numeActor = numeActor;
    }

    String getPrenumeActor() {
        return prenumeActor;
    }

    void setPrenumeActor(String prenumeActor) {
        this.prenumeActor = prenumeActor;
    }

    int getAnulNasterii() {
        return anulNasterii;
    }

    void setAnulNasterii(int anulNasterii) {
        this.anulNasterii = anulNasterii;
    }

    String getNumeleScolii() {
        return numeleScolii;
    }

    void setNumeleScolii(String numeleScolii) {
        this.numeleScolii = numeleScolii;
    }

}
