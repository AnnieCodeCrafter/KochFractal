package Run;

import calculate.Edge;
import calculate.Generator;
import calculate.KochFractal;
import javafx.concurrent.Task;

import java.util.*;

public class LeftEdge  extends Task<ArrayList<Edge>> implements Generator {
    private KochFractal koch;


    //public List<Edge> leftEdges = Collections.synchronizedList(new ArrayList());

    public ArrayList<Edge> leftEdges = new ArrayList<>();

    public void generateLeftEdge() {
        koch.drawKochEdge(0.5, 0.0, (1 - Math.sqrt(3.0) / 2.0) / 2, 0.75, koch.getLevel(), leftEdges);

    }

    public void setNextLvl(int nxt) {
        koch.setLevel(nxt);
    }

//    @Override
//    public void run() {
//            generateLeftEdge();
//           //todo: countup
//
//    }

    public LeftEdge( ) {
        this.koch = new KochFractal(0f, 1, false);
    }

    @Override
    protected ArrayList<Edge> call() throws Exception {
        generateLeftEdge();
        return leftEdges;
    }


    @Override
    public void update(ArrayList<Edge> edges) {
        edges.addAll(leftEdges);
    }
}
