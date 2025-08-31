package CreationalDesignPattern.AbstractFactory.example_2.mac;

import CreationalDesignPattern.AbstractFactory.example_2.Checkbox;

public class MacCheckbox implements Checkbox {
    @Override
    public void event() {
        System.out.println("Mac checkbox clicked!");
    }
}
