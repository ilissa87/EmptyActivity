package com.example.lili.emptyactivity.dessin;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by lili on 31/10/2017.
 */

public class Cercle extends Point implements Frome {
        private double rayon;
    private Paint paint;

        public Cercle(double x, double y, double r) {
            super(x, y);
            this.rayon=r;
            paint=new Paint();
        }

        public Cercle(Point p, double r){
            this(p.getX(), p.getY(), r);
        }

        public Cercle(Segment s) {
            this(s.centre(), s.longueur() / 2);
        }

        public Point centre(){
            return new Point(this.getX(), this.getY());
        }

        @Override
        public String toString() {
            return "Cercle de centre (" +this.getX()+" , "+this.getY()+ ") rayon = " + rayon;
        }
        public void afficher(Canvas c){
          c.drawCircle((float)this.getX(),(float)this.getY(),(float)this.rayon,paint);

        }




}

