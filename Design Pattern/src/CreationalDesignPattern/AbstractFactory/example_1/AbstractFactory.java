package CreationalDesignPattern.AbstractFactory.example_1;

public abstract class AbstractFactory {
    public abstract Shape getShape(String shapeType);
    public abstract Color getColor(String colorType);
}
