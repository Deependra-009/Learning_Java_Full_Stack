package StructuralDesignPattern.Facade;

import StructuralDesignPattern.Facade.SubSystemClasses.Amplifier;
import StructuralDesignPattern.Facade.SubSystemClasses.DvdPlayer;
import StructuralDesignPattern.Facade.SubSystemClasses.Lights;
import StructuralDesignPattern.Facade.SubSystemClasses.Projector;

public class HomeTheaterFacade {
    private Amplifier amp;
    private DvdPlayer dvd;
    private Projector projector;
    private Lights lights;

    public HomeTheaterFacade(Amplifier amp, DvdPlayer dvd, Projector projector, Lights lights) {
        this.amp = amp;
        this.dvd = dvd;
        this.projector = projector;
        this.lights = lights;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        lights.dim(10);
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setVolume(20);
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        dvd.stop();
        dvd.off();
        amp.off();
        projector.off();
        lights.on();
    }
}

