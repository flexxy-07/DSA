package PolyMorphism;

public class Circle extends Shape{
    // this will run when a obj of Circle is created
    // hence it is overriding the parent method
    @Override // this is called annotation, it tells whether a function is overriding or not
    void Area(){
        System.out.println("Area is pie * r * r");
    }
}
