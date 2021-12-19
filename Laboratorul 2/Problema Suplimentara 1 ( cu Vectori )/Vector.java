package problema_suplimentara_1;

import java.util.List;

@SuppressWarnings("unused")
class Vector {

    private List<Integer> elementeDinVector;

    Vector(List<Integer> elementeDinVector) {
        this.elementeDinVector = elementeDinVector;
    }

    double mediaElementelorDinLista() {
        return elementeDinVector.stream().mapToDouble(Integer::doubleValue).average().orElse(0);
    }

    @Override
    public String toString() {
        StringBuilder pentruReturnat = new StringBuilder();
        pentruReturnat.append("v = [");
        this.elementeDinVector.forEach(elementCurent -> pentruReturnat.append(elementCurent).append(","));
        pentruReturnat.deleteCharAt(pentruReturnat.length() - 1).append("]");
        return pentruReturnat.toString();
    }

    List<Integer> getElementeDinVector() {
        return elementeDinVector;
    }

    void setElementeDinVector(List<Integer> elementeDinVector) {
        this.elementeDinVector = elementeDinVector;
    }

}