package problema_1;

@SuppressWarnings("unused")
class Dreptunghi extends Figura {
    private final float lungimeDreptunghi, latimeDreptunghi;

    Dreptunghi(boolean esteSauNuUmplutCuCuloare, int lungimeDreptunghi, int latimeDreptunghi) {
        super(esteSauNuUmplutCuCuloare);
        this.lungimeDreptunghi = lungimeDreptunghi;
        this.latimeDreptunghi = latimeDreptunghi;
    }

    @Override
    float calculeazaPerimetrul() {
        return 2 * (lungimeDreptunghi + latimeDreptunghi);
    }

    @Override
    public String toString() {
        return "Dreptunghi cu lungimea de " + lungimeDreptunghi + "cm si latimea de " + latimeDreptunghi + "cm!";
    }

    @Override
    float calculeazaAria() {
        return lungimeDreptunghi * latimeDreptunghi;
    }

    float getLungimeDreptunghi() {
        return lungimeDreptunghi;
    }

    float getLatimeDreptunghi() {
        return latimeDreptunghi;
    }
}
