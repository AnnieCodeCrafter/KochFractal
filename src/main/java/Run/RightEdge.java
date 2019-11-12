package Run;

import calculate.Edge;
import calculate.KochFractal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RightEdge implements  Runnable {

    private KochFractal koch;

    public List<Edge> rightEdges = Collections.synchronizedList(new ArrayList());

    @Override
    public void run() {

        generateRightEdge();

    }

    public void setNextLvl(int nxt) {
        koch.setLevel(nxt);
    }


    public void generateRightEdge() {

        koch.drawKochEdge((1 + Math.sqrt(3.0) / 2.0) / 2, 0.75, 0.5, 0.0, koch.getLevel(), rightEdges);

    }

    public RightEdge() {
        this.koch = new KochFractal(2f/3f, 1, false);


    }

}
