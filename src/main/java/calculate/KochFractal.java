/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculate;

import fun3kochfractalfx.FUN3KochFractalFX;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.Objects;
import java.util.Observable;

/**
 *
 * @author Peter Boots
 * Modified for FUN3 by Gertjan Schouten
 */
public class KochFractal extends Observable  {

    private int level = 1;      // The current level of the fractal
    private int nrOfEdges = 3;  // The number of edges in the current level of the fractal
    private float hue;          // Hue value of color for next edge
    private boolean cancelled;  // Flag to indicate that calculation has been cancelled
  //  private KochManager kochManager;


    public KochFractal(float hue, int level, boolean cancelled) {
       this.hue = hue;
       this.level = level;
       this.cancelled = cancelled;
       //kochManager = new KochManager(new FUN3KochFractalFX());
    }

    public synchronized void drawKochEdge(double ax, double ay, double bx, double by, int n, List<Edge> f) {
        if (!cancelled) {
            if (n == 1) {
                hue = hue + 1.0f / nrOfEdges;
                Edge e = new Edge(ax, ay, bx, by, Color.hsb(hue*360.0, 1.0, 1.0));
                f.add(e);


            } else {
                double angle = Math.PI / 3.0 + Math.atan2(by - ay, bx - ax);
                double distabdiv3 = Math.sqrt((bx - ax) * (bx - ax) + (by - ay) * (by - ay)) / 3;
                double cx = Math.cos(angle) * distabdiv3 + (bx - ax) / 3 + ax;
                double cy = Math.sin(angle) * distabdiv3 + (by - ay) / 3 + ay;
                final double midabx = (bx - ax) / 3 + ax;
                final double midaby = (by - ay) / 3 + ay;
                drawKochEdge(ax, ay, midabx, midaby, n - 1, f);
                drawKochEdge(midabx, midaby, cx, cy, n - 1, f);
                drawKochEdge(cx, cy, (midabx + bx) / 2, (midaby + by) / 2, n - 1, f);
                drawKochEdge((midabx + bx) / 2, (midaby + by) / 2, bx, by, n - 1, f);
            }
        }
    }






    
    public void cancel() {
        cancelled = true;
    }

    public void setLevel(int lvl) {
        level = lvl;
        nrOfEdges = (int) (3 * Math.pow(4, level - 1));
    }

    public int getLevel() {
        return level;
    }

    public int getNrOfEdges() {
        return nrOfEdges;
    }


}
