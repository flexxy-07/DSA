package Inheritance;

public class Box {
    double l;
    double w;
    double h;

    Box(){
        this.l = -1;
        this.h = -1;
        this.w = -1;
    }

    Box(double side){
        this.l = side;
        this.h = side;
        this.w = side;
    }

    Box(double l, double w, double h){
        this.l = l;
        this.w = w;
        this.h = h;
    }

    Box(Box one){
        this.l = one.l;
        this.h = one.h;
        this.w = one.w;
    }
    public void information(){
        System.out.println("Box is Running");
    }
}
