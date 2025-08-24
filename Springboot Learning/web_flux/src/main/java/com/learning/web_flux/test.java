package com.learning.web_flux;

public class TraditionalThreadExample {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                System.out.println("Running in: " + Thread.currentThread());
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e) {
                    System.out.println("Exception "+e);
                }
            });
            thread.start();
        }
    }
}

