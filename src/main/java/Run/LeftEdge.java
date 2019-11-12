package Run;

import calculate.Edge;
import calculate.KochFractal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeftEdge implements  Runnable {
    private KochFractal koch;


    public List<Edge> leftEdges = Collections.synchronizedList(new ArrayList());

    public void generateLeftEdge() {
        koch.drawKochEdge(0.5, 0.0, (1 - Math.sqrt(3.0) / 2.0) / 2, 0.75, koch.getLevel(), leftEdges );

    }

    public void setNextLvl(int nxt) {
        koch.setLevel(nxt);
    }

    @Override
    public void run() {
            generateLeftEdge();
           //todo: countup

    }

    public LeftEdge( ) {
        this.koch = new KochFractal(0f, 1, false);
    }

}
