package CreationalDesignPattern.Prototype;

import java.util.HashMap;

public class PrototypeCache {

    private static HashMap<String,Shape> shapeHashMap = new HashMap<>();

    public static Shape getShape(String shapeId) throws CloneNotSupportedException {
        Shape cacheShape = shapeHashMap.get(shapeId);
        return (Shape) cacheShape.clone();
    }

    // load initial objects into cache
    public static void loadCache() {
        System.out.println("Initialize Classes");
        Square square = new Square();
        square.setId("1");
        shapeHashMap.put(square.getId(), square);
        System.out.println("Square: "+square.hashCode());

        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        shapeHashMap.put(rectangle.getId(), rectangle);
        System.out.println("Rectangle: "+rectangle.hashCode());
        System.out.println("--------------------------------------");
    }

}
