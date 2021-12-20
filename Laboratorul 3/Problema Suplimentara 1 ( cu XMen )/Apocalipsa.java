package problema_suplimentara_1;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("unused")
public class Apocalipsa extends XMen {
    public Apocalipsa(List<SuperPuteri> superPuteri, String numePersonaj, int varstaPersonaj) {
        super(superPuteri, numePersonaj, varstaPersonaj);
    }

    @Override
    public String toString() {
        StringBuilder pentruReturnat = new StringBuilder();
        pentruReturnat.append("Apocalipsa are ").append(varstaPersonaj).append(" ani");
        if (superPuteri.size() == 0) afisareFaraSuperPuteri(pentruReturnat);
        else afisareCuSuperPuteri(pentruReturnat);
        return pentruReturnat.toString();
    }

    private void afisareCuSuperPuteri(@NotNull StringBuilder pentruReturnat) {
        AtomicInteger nrSuperPutere = new AtomicInteger(1);
        pentruReturnat.append(" si are urmatoarele superputeri:\n");
        superPuteri.forEach(superPutere -> pentruReturnat.append("\t").append(nrSuperPutere.getAndIncrement()).append(") ").append(superPutere).append("\n"));
        pentruReturnat.deleteCharAt(pentruReturnat.length() - 1);
    }

    private void afisareFaraSuperPuteri(@NotNull StringBuilder pentruReturnat) {
        pentruReturnat.append(" si nu are nicio superputere deocamdata!");
    }
}
