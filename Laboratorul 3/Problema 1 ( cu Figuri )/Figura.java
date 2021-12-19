package problema_1;

@SuppressWarnings("unused")
abstract class Figura {
    protected boolean esteSauNuUmplutCuCuloare;

    Figura(boolean esteSauNuUmplutCuCuloare) {
        this.esteSauNuUmplutCuCuloare = esteSauNuUmplutCuCuloare;
    }

    abstract float calculeazaPerimetrul();
    abstract public String toString();
    abstract float calculeazaAria();
}