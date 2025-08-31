package CreateionalDesignPattern.Singleton;

/**
 * Lazy initialization with Thread safe using synchronized
 * */
public class Singleton_3 implements Singleton{

    private static Singleton_3 INSTANCE;
    private Singleton_3(){

    }

    public synchronized static Singleton_3 getInstance() throws InterruptedException {
        if(INSTANCE == null){
            Thread.sleep(50);
            INSTANCE = new Singleton_3();
        }
        return INSTANCE;
    }

}
