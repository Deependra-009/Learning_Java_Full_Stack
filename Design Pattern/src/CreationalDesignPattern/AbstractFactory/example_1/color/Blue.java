package CreationalDesignPattern.AbstractFactory.example_1.color;

import CreationalDesignPattern.AbstractFactory.example_1.Color;

public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill method");
    }
}
