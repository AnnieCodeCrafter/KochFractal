package Run;

import calculate.Edge;
import calculate.Generator;
import calculate.KochFractal;
import javafx.beans.InvalidationListener;
import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

public class BottomEdge   extends Task<ArrayList<Edge>> implements Generator {
    private KochFractal koch;
    public ArrayList<Edge> bottomEdges = new ArrayList<>();

    public BottomEdge() {
        this.koch = new KochFractal(1f/3f, 1, false);

    }

    @Override
    protected ArrayList<Edge> call() throws Exception {
        generateBottomEdge();
        return bottomEdges;
    }

    public void generateBottomEdge() {

        koch.drawKochEdge((1 - Math.sqrt(3.0) / 2.0) / 2, 0.75, (1 + Math.sqrt(3.0) / 2.0) / 2, 0.75, koch.getLevel(), bottomEdges);

    }

//    @Override
//    public void run() {
//            generateBottomEdge();
//
//
//
//    }

    public void setNextLvl(int nxt) {
        koch.setLevel(nxt);
    }


    @Override
    public void update(ArrayList<Edge> edges) {
        edges.addAll(bottomEdges);
    }

}
