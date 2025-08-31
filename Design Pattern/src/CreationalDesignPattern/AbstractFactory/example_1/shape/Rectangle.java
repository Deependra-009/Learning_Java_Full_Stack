package CreationalDesignPattern.AbstractFactory.example_1.shape;

import CreationalDesignPattern.AbstractFactory.example_1.Shape;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw method");
    }
}
