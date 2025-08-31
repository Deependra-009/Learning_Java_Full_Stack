package CreationalDesignPattern.AbstractFactory.example_2.windows;

import CreationalDesignPattern.AbstractFactory.example_2.Button;
import CreationalDesignPattern.AbstractFactory.example_2.Checkbox;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void event() {
        System.out.println("Window checkbox clicked!");
    }
}
