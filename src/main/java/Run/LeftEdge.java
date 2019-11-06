package Run;

import calculate.KochFractal;
import calculate.KochManager;
import fun3kochfractalfx.FUN3KochFractalFX;

public class LeftEdge implements  Runnable {
    private KochFractal koch;
    private NotKochFractal notKoch;


    @Override
    public void run() {
            koch.generateLeftEdge();
            notKoch.CountUp(1);

    }

    public LeftEdge(KochFractal kochFractal, NotKochFractal notKoch) {
        this.koch = kochFractal;
        this.notKoch = notKoch;


    }

}
