package CreationalDesignPattern.Singleton;

/**
 * Bill Pugh Singleton
 * */
public class Singleton_5 implements Singleton {

    private Singleton_5(){}

    private static final class InstanceHolder {
        private static final Singleton_5 INSTANCE = new Singleton_5();
    }

    public synchronized static Singleton_5 getInstance(){
        return InstanceHolder.INSTANCE;
    }


}
