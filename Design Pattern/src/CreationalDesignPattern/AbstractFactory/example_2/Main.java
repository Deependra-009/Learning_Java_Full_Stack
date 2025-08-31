package CreationalDesignPattern.AbstractFactory.example_2;

public class Main {
    public static void main(String[] args) {

        // Get Window factory
        AbstractFactory windows = FactoryProducer.getFactory("windows");
        Button windowButton = windows.clickButton();
        windowButton.event();
        Checkbox windowCheckbox = windows.clickCheckbox();
        windowCheckbox.event();

        System.out.println("----------------------------------------------------");

        // Get Mac Factory
        AbstractFactory mac =FactoryProducer.getFactory("mac");
        Button macButton = mac.clickButton();
        macButton.event();
        Checkbox macCheckbox = mac.clickCheckbox();
        macCheckbox.event();


    }
}
