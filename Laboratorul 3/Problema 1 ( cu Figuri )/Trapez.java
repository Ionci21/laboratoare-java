package problema_1;

import java.util.List;

@SuppressWarnings("unused")
class Trapez extends Figura {
    private final float bazaMica, bazaMare, inaltimeaTrapezulu;
    private final List<Float> listaLaturi;

    Trapez(boolean esteSauNuUmplutCuCuloare, float bazaMica, float bazaMare, float inaltimeaTrapezulu, List<Float> listaLaturi) {
        super(esteSauNuUmplutCuCuloare);
        this.bazaMica = bazaMica;
        this.bazaMare = bazaMare;
        this.inaltimeaTrapezulu = inaltimeaTrapezulu;
        this.listaLaturi = listaLaturi;
    }

    @Override
    public String toString() {
        return "Trapez cu baza mica " + bazaMica + "cm, baza mare " + bazaMare + "cm iar inaltimea " + inaltimeaTrapezulu + "cm!";
    }

    @Override
    float calculeazaPerimetrul() {
        return (float) listaLaturi.stream().mapToDouble(Float::doubleValue).sum();
    }

    @Override
    float calculeazaAria() {
        return ((bazaMica + bazaMare) * inaltimeaTrapezulu) / 2;
    }

    float getBazaMica() {
        return bazaMica;
    }

    float getBazaMare() {
        return bazaMare;
    }

    float getInaltimeaTrapezulu() {
        return inaltimeaTrapezulu;
    }

    List<Float> getListaLaturi() {
        return listaLaturi;
    }
}
