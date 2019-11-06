/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculate;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

//import Run.BottomEdge;
//import Run.LeftEdge;
import Run.NotKochFractal;
//import Run.RightEdge;
import fun3kochfractalfx.FUN3KochFractalFX;
import timeutil.TimeStamp;

/**
 *
 * @author Nico Kuijpers
 * Modified for FUN3 by Gertjan Schouten
 */
public class KochManager {

    //private KochFractal koch;
    // private ArrayList<Edge> edges;
   // private SynchronizedList
   private List<Edge> edges;
    private FUN3KochFractalFX application;
    private TimeStamp tsCalc;
    private TimeStamp tsDraw;
    private int Counter = 0;
//    LeftEdge leftEdge;
//    RightEdge rightEdge;
//    BottomEdge bottomEdge;



    NotKochFractal koch;

    public KochManager(FUN3KochFractalFX application) {
        this.edges = Collections.synchronizedList(new ArrayList());
        this.application = application;
        this.tsCalc = new TimeStamp();
        this.tsDraw = new TimeStamp();
        this.koch = new NotKochFractal(this);

    }


    public void changeLevel(int nxt) {
        edges.clear();
        koch.bottomList.clear();
        koch.leftList.clear();
        koch.rightList.clear();
        koch.setNextLvl(nxt);
        tsCalc.init();
        tsCalc.setBegin("Begin calculating");

        boolean bro = koch.start();

        while(!bro) {
            System.out.println("Still false.");
        }

        if(bro) {
            tsCalc.setEnd("End calculating");
            //     application.setTextNrEdges("" + koch.getNrOfEdges());
            application.setTextCalc(tsCalc.toString());
            drawEdges();
            Counter = 0;
        }


    }
    
    public void drawEdges() {
        tsDraw.init();
        tsDraw.setBegin("Begin drawing");
        application.clearKochPanel();


        edges.addAll(koch.rightList);

        edges.addAll(koch.leftList);

        edges.addAll(koch.bottomList);

        for (Edge e : edges) {
              application.drawEdge(e);
               }

        tsDraw.setEnd("End drawing");
        application.setTextDraw(tsDraw.toString());
    }

    public void stopThreads() {
        koch.stopThreads();
    }


    

}
