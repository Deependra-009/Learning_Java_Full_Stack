package CreationalDesignPattern.Prototype;

/**
 * Prototype design pattern
 * */
public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        // Initialize all classes
        PrototypeCache.loadCache();

        Shape clonedSquare1 = PrototypeCache.getShape("1");
        System.out.println("Shape: "+ clonedSquare1.getType());
        clonedSquare1.draw();
        System.out.println(clonedSquare1.hashCode());

        Shape clonedSquare2 = PrototypeCache.getShape("2");
        System.out.println("Shape: "+ clonedSquare2.getType());
        clonedSquare2.draw();
        System.out.println(clonedSquare2.hashCode());






    }
}
