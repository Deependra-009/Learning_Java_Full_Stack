package CreationalDesignPattern.AbstractFactory.example_1;

import CreationalDesignPattern.AbstractFactory.example_1.color.ColorFactory;
import CreationalDesignPattern.AbstractFactory.example_1.shape.ShapeFactory;

public class FactoryProducer {

    public static AbstractFactory getFactory(String choice){
        return switch(choice.toUpperCase()){
            case "SHAPE" -> new ShapeFactory();
            case "COLOR" -> new ColorFactory();
            default -> null;
        };
    }

}
