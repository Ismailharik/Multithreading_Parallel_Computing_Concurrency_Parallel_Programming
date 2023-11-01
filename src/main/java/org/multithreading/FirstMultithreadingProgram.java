package org.multithreading;

public class FirstMultithreadingProgram extends Thread{




    public static void main(String[] args) {
        Runnable task = new     DefaultRunnable();

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm a new thread! My name is "+ Thread.currentThread().getName());
            }
        });
        Thread t3 = new FirstMultithreadingProgram();// not recommended
        Thread t4 = new Thread(()->{
            System.out.println("I'm a new thread! My name is "+ Thread.currentThread().getName());
        });
        Thread t5 = new Thread(FirstMultithreadingProgram::execute);


        System.out.println("I'm a new thread! My name is "+ Thread.currentThread().getName());
        t1.run();// will also be executed in main thread, remember it doesn't start the thread of execution

        t1.start();// only start method start separate thread
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
    public static void execute(){
        System.out.println("I'm a new thread! My name is "+ Thread.currentThread().getName());
    }
}