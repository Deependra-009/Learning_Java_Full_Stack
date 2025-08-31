package CreationalDesignPattern.AbstractFactory.example_1;

public class Main {

    public static void main(String[] args) {

        // Get Shape Factory
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        Shape rectangle = shapeFactory.getShape("rectangle");
        rectangle.draw();

        // Get Color Factory
        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        Color red = colorFactory.getColor("red");
        red.fill();





    }
}
