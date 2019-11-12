package Run;

import calculate.Edge;
import calculate.KochFractal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BottomEdge implements  Runnable {
    private KochFractal koch;
    public List<Edge> bottomEdges = Collections.synchronizedList(new ArrayList());

    public BottomEdge() {
        this.koch = new KochFractal(1f/3f, 1, false);

    }

    public void generateBottomEdge() {

        koch.drawKochEdge((1 - Math.sqrt(3.0) / 2.0) / 2, 0.75, (1 + Math.sqrt(3.0) / 2.0) / 2, 0.75, koch.getLevel(), bottomEdges);
        //todo: countup
    }

    @Override
    public void run() {
            generateBottomEdge();



    }

    public void setNextLvl(int nxt) {
        koch.setLevel(nxt);
    }



}
