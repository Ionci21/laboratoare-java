package problema_2;

import static java.lang.System.*;
import static java.lang.System.arraycopy;
import static java.lang.System.out;
import static java.util.stream.IntStream.range;

@SuppressWarnings("unused")
class Container {

    private Produs[] tablouProduse;
    private String identificatorContainer;

    Container(Produs produsPentruAdaugat, String identificatorContainer) {
        this.tablouProduse = new Produs[1];
        this.tablouProduse[0] = produsPentruAdaugat;
        this.identificatorContainer = identificatorContainer;
    }

    void adaugaProdusInContainer(Produs produsPentruAdaugat) {
        int dimensiuneTablouInitial = this.tablouProduse.length, dimensiuneTablouNou = dimensiuneTablouInitial + 1;
        Produs[] noulTablou = new Produs[dimensiuneTablouNou];
        arraycopy(this.tablouProduse, 0, noulTablou, 0, dimensiuneTablouInitial);
        noulTablou[dimensiuneTablouNou - 1] = produsPentruAdaugat;
        this.tablouProduse = noulTablou;
    }

    void stergeProdusDinContainer(String numeleProdusului) {
        int dimensiuneTablouInitial = this.tablouProduse.length, dimensiuneTablouNou = dimensiuneTablouInitial - 1, indexulProdusuluiPentruSters = cautaIndexProdus(numeleProdusului);
        if (indexulProdusuluiPentruSters == -1)
            out.println("Produsul cu numele de " + numeleProdusului + " nu exista in containerul cu IDul " + this.identificatorContainer + "!");
        else {
            Produs[] noulTablou = new Produs[dimensiuneTablouNou];
            if (indexulProdusuluiPentruSters >= 0)
                arraycopy(this.tablouProduse, 0, noulTablou, 0, indexulProdusuluiPentruSters);
            if (dimensiuneTablouInitial - (indexulProdusuluiPentruSters + 1) >= 0)
                arraycopy(this.tablouProduse, indexulProdusuluiPentruSters + 1, noulTablou, indexulProdusuluiPentruSters, dimensiuneTablouInitial - (indexulProdusuluiPentruSters + 1));
            this.tablouProduse = noulTablou;
        }
    }

    void modificaCantitateaProdusului(String numeleProdusului, int nouaCantitate) {
        int indexulProdusului = cautaIndexProdus(numeleProdusului);
        if (indexulProdusului == -1)
            out.println("Produsul cu numele " + numeleProdusului + " nu exista in Container-ul cu IDul " + this.identificatorContainer + "!");
        else this.tablouProduse[indexulProdusului].setCantitateProdusl(nouaCantitate);
    }

    private int cautaIndexProdus(String numeleProdusului) {
        int pozitieProdusPentruSters = 0;
        boolean existaProdusul = false;
        for (Produs produsCurent : this.tablouProduse) {
            if (produsCurent.getNumeProdus().equals(numeleProdusului)) {
                existaProdusul = true;
                break;
            }
            pozitieProdusPentruSters++;
        }
        if (existaProdusul) return pozitieProdusPentruSters;
        else return -1;
    }

    public String toString() {
        if (this.tablouProduse.length == 0) return "Containerul cu IDul " + this.identificatorContainer + " este gol!";
        else {
            StringBuilder pentruReturnat = new StringBuilder();
            pentruReturnat.append("In containerul cu IDul ").append(this.identificatorContainer).append(" se afla urmatoarele produse:\n");
            for (Produs produsCurent : this.tablouProduse) pentruReturnat.append(produsCurent).append("\n");
            return pentruReturnat.deleteCharAt(pentruReturnat.length() - 1).toString();
        }
    }

    Produs[] getTablouProduse() {
        return tablouProduse;
    }

    void setTablouProduse(Produs[] tablouProduse) {
        this.tablouProduse = tablouProduse;
    }

    String getIdentificatorContainer() {
        return identificatorContainer;
    }

    void setIdentificatorContainer(String identificatorContainer) {
        this.identificatorContainer = identificatorContainer;
    }

}
