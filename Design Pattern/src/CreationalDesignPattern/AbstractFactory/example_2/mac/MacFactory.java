package CreationalDesignPattern.AbstractFactory.example_2.mac;

import CreationalDesignPattern.AbstractFactory.example_2.AbstractFactory;
import CreationalDesignPattern.AbstractFactory.example_2.Button;
import CreationalDesignPattern.AbstractFactory.example_2.Checkbox;

public class MacFactory extends AbstractFactory {
    @Override
    public Button clickButton() {
        return new MacButton();
    }

    @Override
    public Checkbox clickCheckbox() {
        return new MacCheckbox();
    }
}
