package problema_3;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("unused")
class Banca {
    private static double dobandaAnuala;
    private static double dobandaLunara;
    private final String numeleBancii;
    private final List<Cont> listaConturi;
    private boolean sfarsitDeLuna;

    Banca(String numeleBancii, List<Cont> listaConturi, double dobandaAnuala, double dobandaLunara, boolean sfarsitDeLuna) {
        this.numeleBancii = numeleBancii;
        this.listaConturi = listaConturi;
        Banca.dobandaAnuala = dobandaAnuala;
        Banca.dobandaLunara = dobandaLunara;
        this.sfarsitDeLuna = sfarsitDeLuna;
    }

    private static void platesteDobanda(Cont contCurent) {
        aplicaDobandaLunara(contCurent);
        aplicaDobandaAnuala(contCurent);
    }

    private static void aplicaDobandaLunara(Cont contCurent) {
        if (contCurent instanceof ContCuDobanda || contCurent instanceof ContCuVerificare)
            contCurent.soldCont -= dobandaLunara * contCurent.soldCont;
    }

    private static void aplicaDobandaAnuala(Cont contCurent) {
        if (contCurent instanceof ContCD && !((ContCD) contCurent).esteDobandaPlatitaPeAnulCurent())
            contCurent.soldCont -= dobandaAnuala * contCurent.soldCont;
    }

    void depunereNumerarInCont(String detinatorulContului, String pinCont, double sumaPentruDepus) {
        boolean statusTranzactie = cautaCont(detinatorulContului, pinCont, sumaPentruDepus); // daca am reusit sa depunem numerar in sold -> true
        if (statusTranzactie)
            System.out.println("Suma de " + sumaPentruDepus + " a fost depusa cu succes in cont!"); // daca true
        else System.out.println("Nume sau PIN gresit!"); // afisam daca nu am reusit sa depunem sold
    }

    private boolean cautaCont(String detinatorulContului, String pinCont, double sumaPentruDepus) {
        boolean statusRetragere = false; // false daca nu exista niciun cont cu numele detinatorului si PINul primit ca parametru
        for (Cont contCurent : listaConturi)
            if (contCurent.posesorCont.equals(detinatorulContului) && contCurent.pinCont.equals(pinCont)) {
                ((OperatiiConturi) contCurent).depunereNumerer(sumaPentruDepus);
                statusRetragere = true;
                break;
            }
        return statusRetragere; // daca am gasit cont -> true altfel -> false
    }

    void retragereNumerarDinCont(String detinatorulContului, String pinCont, double sumaPentruRetras) {
        boolean statusTranzactie = efectueazaTranzactia(detinatorulContului, pinCont, sumaPentruRetras);
        if (statusTranzactie) System.out.println("Suma de " + sumaPentruRetras + " a fost retrasa cu succes din cont!");
        else System.out.println("Nu s-a putut retrage suma din cont");
    }

    private boolean efectueazaTranzactia(String detinatorulContului, String pinCont, double sumaPentruRetras) {
        return listaConturi
                .stream()
                .filter(contCurent -> contCurent.posesorCont.equals(detinatorulContului) && contCurent.pinCont.equals(pinCont))
                .findFirst()
                .filter(contCurent -> ((OperatiiConturi) contCurent).retragereNumerar(sumaPentruRetras))
                .isPresent();
    }

    void aplicareDobanda() {
        listaConturi.forEach(Banca::platesteDobanda);
        System.out.println("Dobanzile au fost aplicate cu succes!");
    }

    @Override
    public String toString() {
        StringBuilder pentruReturnat = new StringBuilder();
        AtomicInteger nrContCurent = new AtomicInteger(1);
        if (esteListaGoala()) afisareFaraConturi(pentruReturnat);
        else afisareCuConturi(pentruReturnat, nrContCurent);
        return pentruReturnat.toString();
    }

    private boolean esteListaGoala() {
        return listaConturi.size() == 0;
    }

    private void afisareFaraConturi(@NotNull StringBuilder pentruReturnat) {
        pentruReturnat.append("La ").append(numeleBancii).append(" momentan nu avem conturi create");
    }

    private void afisareCuConturi(@NotNull StringBuilder pentruReturnat, AtomicInteger nrContCurent) {
        pentruReturnat.append("La ").append(numeleBancii).append(" exista urmatoarele conturi:").append("\n");
        listaConturi.forEach(contCurent -> pentruReturnat.append("\t").append(nrContCurent.getAndIncrement()).append(") ").append(contCurent).append("\n"));
        pentruReturnat.deleteCharAt(pentruReturnat.length() - 1);
    }

    void aplicaTaxaAdministrare() {
        boolean sfarsitDeLuna = this.sfarsitDeLuna;
        if (!sfarsitDeLuna) aplicareTaxa();
        else aplicareSoldSfarsitDeLuna();
    }

    private void aplicareSoldSfarsitDeLuna() {
        listaConturi.forEach(contCurent -> contCurent.soldCont -= 0.10 * contCurent.soldCont);
        System.out.println("Am aplicat cu succes taxa de administrare in valoare de 10% din soldul conturilor");
    }

    private void aplicareTaxa() {
        listaConturi.forEach(contCurent -> contCurent.soldCont -= 10);
        System.out.println("Am aplicat cu succes taxa de administrare in valoare de 10RON");
    }

    public String getNumeleBancii() {
        return numeleBancii;
    }

    public List<Cont> getListaConturi() {
        return listaConturi;
    }

    public boolean isSfarsitDeLuna() {
        return sfarsitDeLuna;
    }

    public void setSfarsitDeLuna(boolean sfarsitDeLuna) {
        this.sfarsitDeLuna = sfarsitDeLuna;
    }
}
