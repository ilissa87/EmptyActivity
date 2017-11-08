package com.example.lili.emptyactivity.dessin;

/**
 * Created by lili on 31/10/2017.
 */

public class Point {
    private double x,y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Point p){
        return Math.sqrt(((this.x-p.x)*(this.x-p.x))+((this.y-p.y)*(this.y-p.y)));
    }
    @Override
    public String toString() {
        return "Point{"+ x + "," + y + '}';
    }


}


