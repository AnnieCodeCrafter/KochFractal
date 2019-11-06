package Run;

import calculate.KochFractal;




public class RightEdge implements  Runnable {

    private KochFractal koch;
    private NotKochFractal notKoch;
    @Override
    public void run() {
            koch.generateRightEdge();
            notKoch.CountUp(1);

    }

    public RightEdge(KochFractal kochFractal, NotKochFractal notKoch) {
        this.koch = kochFractal;
        this.notKoch = notKoch;

    }

}
