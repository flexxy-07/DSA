package PolyMorphism;
// Way of representing a single identity in multiple ways
// There are two types of Polymorphism :

// (a)Compile Time / Static Polymorphism : Achieved via Method Overloading
// (b)Runtime / Dynamic Polymorphism : Achieved via Method Overriding;

// You cannot override a method which is Final
public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();
        Circle circle = new Circle();
        Square square = new Square();
// If type of the reference is Parent Class, but the object is type of subclass
        square.Area();
    }
}
// the reference type defines which method can be accessed
// the object types defines which one to run
