package problema_suplimentara_1;

import java.util.List;

@SuppressWarnings("unused")
abstract class XMen {
    protected List<SuperPuteri> superPuteri;
    protected String numePersonaj;
    protected int varstaPersonaj;

    public XMen(List<SuperPuteri> superPuteri, String numePersonaj, int varstaPersonaj) {
        this.superPuteri = superPuteri;
        this.numePersonaj = numePersonaj;
        this.varstaPersonaj = varstaPersonaj;
    }

    public String getNumePersonaj() {
        return numePersonaj;
    }

    public void setNumePersonaj(String numePersonaj) {
        this.numePersonaj = numePersonaj;
    }

    public List<SuperPuteri> getSuperPuteri() {
        return superPuteri;
    }

    public void setSuperPuteri(List<SuperPuteri> superPuteri) {
        this.superPuteri = superPuteri;
    }
}
