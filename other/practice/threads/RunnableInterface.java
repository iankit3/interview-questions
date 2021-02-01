package practice.threads;

public class RunnableInterface {
    public static class MyThread implements Runnable{
        public void run(){
            System.out.println(System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Thread myThread = new Thread(new MyThread());
        myThread.start();
    }
}
