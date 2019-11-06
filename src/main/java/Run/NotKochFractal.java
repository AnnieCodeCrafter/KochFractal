package Run;

import calculate.Edge;
import calculate.KochFractal;
import calculate.KochManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotKochFractal {

    private int Counter;

    private KochManager kochManager;

    private KochFractal koch = new KochFractal(this);

    private BottomEdge bottomEdge = new BottomEdge(koch, this);
    private LeftEdge leftEdge = new LeftEdge(koch, this);
    private RightEdge rightEdge = new RightEdge(koch, this);

    public List<Edge> bottomList =  Collections.synchronizedList(new ArrayList());
    public List<Edge> leftList =  Collections.synchronizedList(new ArrayList());
    public  List<Edge> rightList =  Collections.synchronizedList(new ArrayList());
    public List<Edge> notKochList = Collections.synchronizedList(new ArrayList());


//    public void addEdge(Edge e) {
//
//    }

    public synchronized int CountUp(int Counting) {
        Counter += Counting;
        return Counter;
    }


    Thread trLeft = new Thread(leftEdge);
    Thread trRight = new Thread(rightEdge);
    Thread trBottom = new Thread(bottomEdge);

     public boolean start() {

         stopThreads();

         trLeft.start();
         trRight.start();
         trBottom.start();

         while (CountUp(0) != 3) {
             System.out.println("Not done yet");
         }


         if (CountUp(0) == 3) {
            stopThreads();
             return true;
         }
         else {
             return false;
         }
     }


     public void setNextLvl(int nxt) {
         koch.setLevel(nxt);
     }


     public NotKochFractal(KochManager kochManager) {
         this.kochManager = kochManager;
     }

     public void stopThreads() {
         if(trLeft.isAlive() || trRight.isAlive() || trBottom.isAlive() ) {
             trBottom.interrupt();
             trRight.interrupt();
             trLeft.interrupt();
         }
     }




}
