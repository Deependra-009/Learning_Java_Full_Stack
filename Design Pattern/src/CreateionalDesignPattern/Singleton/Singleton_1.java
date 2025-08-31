package CreateionalDesignPattern.Singleton;

/**
 * Eager initialization with Thread safe
 * */
public class Singleton_1 implements Singleton {

    private static final Singleton_1 INSTANCE = new Singleton_1();

    private Singleton_1(){}

    public static Singleton_1 getInstance(){
        return INSTANCE;
    }

}
