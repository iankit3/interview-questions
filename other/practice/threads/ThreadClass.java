package practice.threads;

public class ThreadClass {
    public class MyThread extends Thread{
        public void run(){
            System.out.println("Started");
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ThreadClass tc = new ThreadClass();
        MyThread myThread = tc.new MyThread();
        myThread.start();
    }
}
