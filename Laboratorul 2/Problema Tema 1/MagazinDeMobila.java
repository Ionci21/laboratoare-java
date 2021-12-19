package problema_tema_1;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("unused")
public class MagazinDeMobila {

    private String numeMagazin, adresaMagazin;
    private List<Mobila> stocMobile;

    public MagazinDeMobila(String numeMagazin, String adresaMagazin, List<Mobila> stocMobile) {
        this.numeMagazin = numeMagazin;
        this.adresaMagazin = adresaMagazin;
        this.stocMobile = stocMobile;
    }

    @Override
    public String toString() {
        StringBuilder pentruReturnat = new StringBuilder();
        pentruReturnat.append("\tIn magazinul ").append(this.numeMagazin).append(" de pe strada ").append(this.adresaMagazin);
        if (this.stocMobile.size() > 0) {
            AtomicInteger nrMobilaCurenta = new AtomicInteger(1);
            pentruReturnat.append(" avem urmatoarele mobile:\n");
            this.stocMobile.forEach(mobilaCurenta -> {
                pentruReturnat.append("\t\t").append(nrMobilaCurenta.getAndIncrement()).append(") ").append(mobilaCurenta).append("\n");
            });
            return pentruReturnat.deleteCharAt(pentruReturnat.length() - 1).toString();
        }
        pentruReturnat.append(" nu exista momentan nicio mobila pe stoc!");
        return pentruReturnat.toString();

    }

    public String getNumeMagazin() {
        return numeMagazin;
    }

    public void setNumeMagazin(String numeMagazin) {
        this.numeMagazin = numeMagazin;
    }

    public String getAdresaMagazin() {
        return adresaMagazin;
    }

    public void setAdresaMagazin(String adresaMagazin) {
        this.adresaMagazin = adresaMagazin;
    }

    public List<Mobila> getStocMobile() {
        return stocMobile;
    }

    public void setStocMobile(List<Mobila> stocMobile) {
        this.stocMobile = stocMobile;
    }

}
