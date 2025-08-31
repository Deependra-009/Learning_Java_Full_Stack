package CreationalDesignPattern.Singleton;

/**
 * Lazy initialization with Thread safe [double check]
 * */
public class Singleton_4 implements Singleton {

    private static Singleton_4 INSTANCE;

    private Singleton_4(){}

    public synchronized static Singleton_4 getInstance(){
        if(INSTANCE==null){
            synchronized (Singleton_4.class){
                if(INSTANCE == null){
                    INSTANCE=new Singleton_4();
                }
            }
        }
        return INSTANCE;
    }


}
