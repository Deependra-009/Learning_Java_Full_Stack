package CreationalDesignPattern.AbstractFactory.example_1.shape;

import CreationalDesignPattern.AbstractFactory.example_1.Shape;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw method");
    }
}
