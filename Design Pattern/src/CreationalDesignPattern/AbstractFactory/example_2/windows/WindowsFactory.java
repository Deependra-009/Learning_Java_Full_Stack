package CreationalDesignPattern.AbstractFactory.example_2.windows;

import CreationalDesignPattern.AbstractFactory.example_2.AbstractFactory;
import CreationalDesignPattern.AbstractFactory.example_2.Button;
import CreationalDesignPattern.AbstractFactory.example_2.Checkbox;

public class WindowsFactory extends AbstractFactory {
    @Override
    public Button clickButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox clickCheckbox() {
        return new WindowsCheckbox();
    }
}
