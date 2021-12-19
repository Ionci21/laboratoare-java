package problema_1;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

@SuppressWarnings("unused")
class Cerc extends Figura {
    private final float razaCercului;

    Cerc(boolean esteSauNuUmplutCuCuloare, float razaCercului) {
        super(esteSauNuUmplutCuCuloare);
        this.razaCercului = razaCercului;
    }

    @Override
    float calculeazaPerimetrul() {
        return (float) (2 * PI * razaCercului);
    }

    @Override
    public String toString() {
        return "Cerc cu raza de " + razaCercului + "!";
    }

    @Override
    float calculeazaAria() {
        return (float) (PI * pow(razaCercului, 2));
    }

    float getRazaCercului() {
        return razaCercului;
    }
}
