package StructuralDesignPattern.Decorator;

/**
 * Decorator Design Pattern
 * */
public class Main {

    public static void main(String[] args) {

        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " -> Rs." + coffee.getCost());

        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.getDescription() + " -> Rs." + coffee.getCost());

    }
}
