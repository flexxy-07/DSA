package Inheritance;
// parent class can not access the properties of child class
// the child class cares for the parent class,, so it will let its values be initialised first.
public class BoxWeight extends Box{
    double weight;

    public BoxWeight(){         //Constructor
        this.weight = -1;
    }
    BoxWeight(BoxWeight other){
        super(other);
        this.weight = other.weight;
    }

    public BoxWeight(double l, double w, double h, double weight) {
        super(l, w, h); // it calls the parent class constructor for l,w,h;
        // used to initialize the values present in parent class
        // calls the constructor directly from the above
        this.weight = weight;
    }
}

