package CreationalDesignPattern.AbstractFactory.example_2.mac;

import CreationalDesignPattern.AbstractFactory.example_2.Button;

public class MacButton implements Button {
    @Override
    public void event() {
        System.out.println("Mac button clicked!");
    }
}
