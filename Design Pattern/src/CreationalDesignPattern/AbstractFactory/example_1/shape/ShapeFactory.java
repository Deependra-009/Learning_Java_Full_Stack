package CreationalDesignPattern.AbstractFactory.example_1.shape;

import CreationalDesignPattern.AbstractFactory.example_1.AbstractFactory;
import CreationalDesignPattern.AbstractFactory.example_1.Color;
import CreationalDesignPattern.AbstractFactory.example_1.Shape;

public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        return switch (shapeType.toUpperCase()){
            case "SQUARE" -> new Square();
            case "RECTANGLE" -> new Rectangle();
            default -> null;
        };
    }

    @Override
    public Color getColor(String colorType) {
        return null;
    }
}
