package Run;

import calculate.KochFractal;

public class BottomEdge implements  Runnable {
    private KochFractal koch;
    private NotKochFractal notKoch;


    @Override
    public void run() {
            koch.generateBottomEdge();
            notKoch.CountUp(1);


    }

    public BottomEdge(KochFractal kochFractal, NotKochFractal notKoch) {
        this.koch = kochFractal;
        this.notKoch = notKoch;

    }

}
