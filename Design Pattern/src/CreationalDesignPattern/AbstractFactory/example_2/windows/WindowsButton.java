package CreationalDesignPattern.AbstractFactory.example_2.windows;

import CreationalDesignPattern.AbstractFactory.example_2.Button;

public class WindowsButton implements Button {
    @Override
    public void event() {
        System.out.println("Window button clicked!");
    }
}
