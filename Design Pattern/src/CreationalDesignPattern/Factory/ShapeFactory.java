package CreationalDesignPattern.Factory;

public class ShapeFactory {

    public static Shape createObject(String type){
        return switch (type.toUpperCase()){
            case "SQUARE" -> new Square();
            case "RECTANGLE" -> new Rectangle();
            default -> null;
        };
    }

}
