package prima_problema;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@SuppressWarnings("unused")
class Elev {
    private String numeElev;
    private int clasaElevului; // 0-12
    private Map<String, List<Integer>> carnetDeNote; // notele sa fie intre 1-10

    Elev(String numeElev, int clasaElevului, Map<String, List<Integer>> carnetDeNote) throws ExceptiiElev {
        boolean clasaIntre0Si12 = clasaElevului >= 0 && clasaElevului <= 12;
        if (!clasaIntre0Si12) throw new ExceptiiElev(ExceptiiElev.CLASA_GRESITA);
        boolean toateNoteleIntre1Si10 = carnetDeNote.values().stream().flatMap(Collection::stream).allMatch(notaCurenta -> (notaCurenta >= 1 && notaCurenta <= 10));
        if (!toateNoteleIntre1Si10) throw new ExceptiiElev(ExceptiiElev.NOTA_GRESITA);
        this.numeElev = numeElev;
        this.clasaElevului = clasaElevului;
        this.carnetDeNote = carnetDeNote;
    }

    @Override
    public String toString() {
        StringBuilder pentruReturnat = new StringBuilder();
        pentruReturnat.append("Numele elevului este ").append(getNumeElev()).append(", este in clasa a ").append(getClasaElevului())
                .append(" si are urmatoarea situatie:\n");
        carnetDeNote.forEach((cheiaCurenta, valoareaCurenta) -> {
            pentruReturnat.append("La materia ").append(cheiaCurenta).append(" avem urmatoarele note: ");
            /*valoareaCurenta.forEach(notaCurenta -> pentruReturnat.append(notaCurenta).append(" "));*/
            if (valoareaCurenta.size() == 0) pentruReturnat.append("Nicio nota!\n");
            else {
                valoareaCurenta.stream().mapToInt(Integer::intValue).mapToObj(nrCurent -> nrCurent + ", ").forEach(pentruReturnat::append);
                pentruReturnat.deleteCharAt(pentruReturnat.length() - 1).deleteCharAt(pentruReturnat.length() - 1).append("\n");
            }
        });
        return pentruReturnat.deleteCharAt(pentruReturnat.length() - 1).toString();
    }

    String getNumeElev() {
        return numeElev;
    }
    void setNumeElev(String numeElev) {
        this.numeElev = numeElev;
    }
    int getClasaElevului() {
        return clasaElevului;
    }
    void setClasaElevului(int clasaElevului) {
        this.clasaElevului = clasaElevului;
    }
    Map<String, List<Integer>> getCarnetDeNote() {
        return carnetDeNote;
    }
    void setCarnetDeNote(Map<String, List<Integer>> carnetDeNote) {
        this.carnetDeNote = carnetDeNote;
    }

    /**
     * Calculeaza media la o anumita materie
     * @param numeleMateriei numele materiei la care calculam media ( String )
     * @return media la materia respectiva ( double )
     */
    double calculeazaMedieMaterie(String numeleMateriei) {
        AtomicReference<Double> mediaGenerala = new AtomicReference<>((double) 0);
        carnetDeNote.forEach((materieCurenta, listaNote) -> {
            if (materieCurenta.equals(numeleMateriei))
                mediaGenerala.set(listaNote.stream().mapToDouble(Integer::doubleValue).average().orElse(0));
        });
        return mediaGenerala.get();
    }

    /**
     * Calculeaza media generala a elevului
     * @return media generala ( double )
     */
    double calculeazaMediaGenerala() {
        return carnetDeNote.values().stream().map(listaNote -> listaNote.stream().mapToDouble(nrCurent -> nrCurent).average().orElse(0)).mapToDouble(nrCurent -> nrCurent).average().orElse(0);
    }

    /**
     * Adauga o nota la o materie, daca materia nu exista adauga si materia si nota in carnetul elevului
     * @param numeleMateriei numele materiei ( String )
     * @param notaPentruAdaugat nota pe care vrem sa o adaugam ( int )
     * @throws ExceptiiElev arunca exceptie daca nota nu e intre 1 si 10
     */
    void adaugaNota(String numeleMateriei, int notaPentruAdaugat) throws ExceptiiElev {
        boolean notaIntre1Si10 = notaPentruAdaugat >= 1 && notaPentruAdaugat <= 10;
        if (!notaIntre1Si10) throw new ExceptiiElev(ExceptiiElev.NOTA_GRESITA);
        if (carnetDeNote.containsKey(numeleMateriei)) carnetDeNote.get(numeleMateriei).add(notaPentruAdaugat);
        else carnetDeNote.put(numeleMateriei, new ArrayList<>(List.of(notaPentruAdaugat)));
        System.out.println("Nota " + notaPentruAdaugat + " a fost adaugata cu succes la materia " + numeleMateriei + "!");
    }

}
