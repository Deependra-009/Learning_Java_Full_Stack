package StructuralDesignPattern.Facade;

import StructuralDesignPattern.Facade.SubSystemClasses.Amplifier;
import StructuralDesignPattern.Facade.SubSystemClasses.DvdPlayer;
import StructuralDesignPattern.Facade.SubSystemClasses.Lights;
import StructuralDesignPattern.Facade.SubSystemClasses.Projector;

/**
 * Facade Design Pattern
 * */
public class FacadePatternDemo {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        DvdPlayer dvd = new DvdPlayer();
        Projector projector = new Projector();
        Lights lights = new Lights();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd, projector, lights);

        homeTheater.watchMovie("Inception");
        System.out.println();
        homeTheater.endMovie();
    }
}
