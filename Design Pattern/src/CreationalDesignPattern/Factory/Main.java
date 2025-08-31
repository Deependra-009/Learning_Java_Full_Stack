package CreationalDesignPattern.Factory;

/**
 * Factory design pattern
 * */
public class Main {

    public static void main(String[] args) {

        Shape square = ShapeFactory.createObject("square");
        assert square != null;
        square.draw();

        Shape rectangle = ShapeFactory.createObject("rectangle");
        assert rectangle != null;
        rectangle.draw();

    }
}
