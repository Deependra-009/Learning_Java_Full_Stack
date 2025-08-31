package CreationalDesignPattern.AbstractFactory.example_1.color;

import CreationalDesignPattern.AbstractFactory.example_1.AbstractFactory;
import CreationalDesignPattern.AbstractFactory.example_1.Color;
import CreationalDesignPattern.AbstractFactory.example_1.Shape;

public class ColorFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        return null;
    }

    @Override
    public Color getColor(String colorType) {
        return switch (colorType.toUpperCase()){
            case "RED" -> new Red();
            case "BLUE" -> new Blue();
            default -> null;
        };
    }
}
