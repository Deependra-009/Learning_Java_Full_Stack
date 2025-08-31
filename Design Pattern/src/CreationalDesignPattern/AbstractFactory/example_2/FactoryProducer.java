package CreationalDesignPattern.AbstractFactory.example_2;

import CreationalDesignPattern.AbstractFactory.example_2.mac.MacFactory;
import CreationalDesignPattern.AbstractFactory.example_2.windows.WindowsFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String type){
        return switch (type.toUpperCase()){
            case "WINDOWS" -> new WindowsFactory();
            case "MAC" -> new MacFactory();
            default -> null;
        };
    }
}
