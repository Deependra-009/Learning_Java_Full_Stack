package CreationalDesignPattern.Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Singleton design pattern
 * */
public class Main {

    public static void main(String[] args) throws Exception {

        // Eager initialization with Thread safe
        createInstanceWithMultipleThread(1);

        // Lazy initialization without Thread safe
        createInstanceWithMultipleThread(2);

        // Lazy initialization with Thread safe using synchronized
        createInstanceWithMultipleThread(3);

        // Lazy initialization with Thread safe [double check]
        createInstanceWithMultipleThread(4);

        // Bill Pugh Singleton
        createInstanceWithMultipleThread(5);

    }

    private static void createInstanceWithMultipleThread(int type) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.execute(() -> {
                Singleton singleton= null;
                try {
                    singleton = getInstance(type);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName() +" Singleton hashcode: "+ singleton.hashCode());
            });
        }

        executor.shutdown();

        executor.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("-------------------------------------------------");
    }

    private static Singleton getInstance(int type) throws InterruptedException {
        return switch (type) {
            case 1 -> Singleton_1.getInstance();
            case 2 -> Singleton_2.getInstance();
            case 3 -> Singleton_3.getInstance();
            case 4 -> Singleton_4.getInstance();
            case 5 -> Singleton_5.getInstance();
            default -> null;
        };
    }

}
