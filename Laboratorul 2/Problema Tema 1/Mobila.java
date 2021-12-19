package problema_tema_1;

@SuppressWarnings("unused")
public class Mobila {

    double lungimeMobila, latimeMobila, inaltimeMobila, pretMobila;
    private String numeMobila, descriereMobila, materialMobila;

    Mobila(String numeMobila, String descriereMobila, String materialMobila, double lungimeMobila, double latimeMobila, double inaltimeMobila, double pretMobila) {
        this.numeMobila = numeMobila;
        this.descriereMobila = descriereMobila;
        this.materialMobila = materialMobila;
        this.lungimeMobila = lungimeMobila;
        this.latimeMobila = latimeMobila;
        this.inaltimeMobila = inaltimeMobila;
        this.pretMobila = pretMobila;
    }

    @Override
    public String toString() {
        return "Denumirea mobilei \"" + this.numeMobila + "\" construita din \"" + this.materialMobila + "\" de dimensiuni \"" + this.latimeMobila + "cm x " + this.lungimeMobila + "cm x " + this.inaltimeMobila + "cm\" si costa \"" + this.pretMobila + "\" si descrierea este \"" + this.descriereMobila + "\"!";
    }

    String getNumeMobila() {
        return numeMobila;
    }

    void setNumeMobila(String numeMobila) {
        this.numeMobila = numeMobila;
    }

    String getDescriereMobila() {
        return descriereMobila;
    }

    void setDescriereMobila(String descriereMobila) {
        this.descriereMobila = descriereMobila;
    }

    String getMaterialMobila() {
        return materialMobila;
    }

    void setMaterialMobila(String materialMobila) {
        this.materialMobila = materialMobila;
    }

    double getLungimeMobila() {
        return lungimeMobila;
    }

    void setLungimeMobila(double lungimeMobila) {
        this.lungimeMobila = lungimeMobila;
    }

    double getLatimeMobila() {
        return latimeMobila;
    }

    void setLatimeMobila(double latimeMobila) {
        this.latimeMobila = latimeMobila;
    }

    double getInaltimeMobila() {
        return inaltimeMobila;
    }

    void setInaltimeMobila(double inaltimeMobila) {
        this.inaltimeMobila = inaltimeMobila;
    }

    double getPretMobila() {
        return pretMobila;
    }

    void setPretMobila(double pretMobila) {
        this.pretMobila = pretMobila;
    }

}
