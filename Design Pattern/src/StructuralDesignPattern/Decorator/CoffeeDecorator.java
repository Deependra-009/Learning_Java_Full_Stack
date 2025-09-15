package StructuralDesignPattern.Decorator;

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee; // wrapping object

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }
}

