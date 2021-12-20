package problema_3;

abstract class Cont {
    protected String posesorCont, pinCont;
    protected double soldCont;

    public Cont(String posesorCont, String pinCont, double soldCont) {
        this.posesorCont = posesorCont;
        this.pinCont = pinCont;
        this.soldCont = soldCont;
    }
}
