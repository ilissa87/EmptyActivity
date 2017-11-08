package com.example.lili.emptyactivity.dessin;

import android.graphics.Canvas;
import android.graphics.Paint;
/**
 * Created by lili on 31/10/2017.
 */

public class Segment implements Frome  {
    private Point p1, p2;
    private Paint paint;

    public Segment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        Paint paint = new Paint();

    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }



    public Point centre(){
        return new Point((p1.getX()+p2.getX())/2,(p1.getY()+p2.getY())/2);
    }
    public double longueur(){
        return p1.distance(p2);

    }

    @Override
    public String toString() {
        return "Segment point1 (" + p1.getX() + "," +p1.getY()+") point2 (" + p2.getX() +
                "," +p2.getY()+ ")";
    }
    public void afficher(Canvas c){
       c.drawLine((float)p1.getX(),(float)p1.getY(),(float)p2.getX(),(float)p1.getY(),paint);

    }



}

