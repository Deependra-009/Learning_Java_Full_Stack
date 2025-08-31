package CreationalDesignPattern.Singleton;

/**
 * Lazy initialization without Thread safe
 * */
public class Singleton_2 implements Singleton{

    private static Singleton_2 INSTANCE;
    private Singleton_2(){

    }

    public static Singleton_2 getInstance() throws InterruptedException {
        if(INSTANCE == null){
            Thread.sleep(50);
            INSTANCE = new Singleton_2();
        }
        return INSTANCE;
    }

}
