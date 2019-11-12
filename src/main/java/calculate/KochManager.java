/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculate;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;


import Run.BottomEdge;
import Run.LeftEdge;
import Run.RightEdge;
import fun3kochfractalfx.FUN3KochFractalFX;
import timeutil.TimeStamp;

/**
 *
 * @author Nico Kuijpers
 * Modified for FUN3 by Gertjan Schouten
 */
public class KochManager {

   private List<Edge> edges;
    private FUN3KochFractalFX application;
    private TimeStamp tsCalc;
    private TimeStamp tsDraw;
    private int Counter = 0;

    BottomEdge bottomEdge = new BottomEdge();
    LeftEdge leftEdge = new LeftEdge();
    RightEdge rightEdge = new RightEdge();





    public KochManager(FUN3KochFractalFX application) {
        this.edges = Collections.synchronizedList(new ArrayList());
        this.application = application;
        this.tsCalc = new TimeStamp();
        this.tsDraw = new TimeStamp();

    }


    public void changeLevel(int nxt) {
        edges.clear();
        bottomEdge.bottomEdges.clear();
        leftEdge.leftEdges.clear();
        rightEdge.rightEdges.clear();
        bottomEdge.setNextLvl(nxt);
        rightEdge.setNextLvl(nxt);
        leftEdge.setNextLvl(nxt);

        Thread trRight = new Thread(rightEdge);
        Thread trLeft = new Thread(leftEdge);
        Thread trBottom = new Thread(bottomEdge);

        if(trRight.isAlive()) {
            trRight.interrupt();
        }

        if(trLeft.isAlive()) {
            trLeft.interrupt();
        }

        if(trBottom.isAlive()) {
            trBottom.interrupt();
        }


        tsCalc.init();
        tsCalc.setBegin("Begin calculating");

//        bottomEdge.run();
//        leftEdge.run();
//        rightEdge.run();

        trRight.start();
        trLeft.start();
        trBottom.start();

        while(trRight.isAlive()) {
            System.out.println("Right busy");
        }

        while(trLeft.isAlive()) {
            System.out.println("Left busy");
        }

        while(trBottom.isAlive()) {
            System.out.println("Bottom busy");
        }

            try {
                trRight.join();
                trLeft.join();
                trBottom.join();

//                trBottom.interrupt();
//                trLeft.interrupt();
//                trBottom.interrupt();
                tsCalc.setEnd("End calculating");
                //     application.setTextNrEdges("" + koch.getNrOfEdges());
                application.setTextCalc(tsCalc.toString());
                drawEdges();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



    }

    
    public void drawEdges() {
        tsDraw.init();
        tsDraw.setBegin("Begin drawing");
        application.clearKochPanel();


        edges.addAll(rightEdge.rightEdges);

        edges.addAll(leftEdge.leftEdges);

        edges.addAll(bottomEdge.bottomEdges);

        for (Edge e : edges) {
              application.drawEdge(e);
               }

        tsDraw.setEnd("End drawing");
        application.setTextDraw(tsDraw.toString());
    }


    public void stopThreads() {

    }


    

}
