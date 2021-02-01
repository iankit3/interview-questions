package practice.designpatterns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SingletonImplmentation {
    static final class Singleton {
        public int j = 0;
        static Singleton instance = null;
        static Singleton getInstance(){
            if(instance == null){
                instance = new Singleton();
            }     
            return instance;
        }
    }

    static void print(Object s){
        System.out.println(s.toString());
    }

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());

        int noOfCores = Runtime.getRuntime().availableProcessors();
        ExecutorService ex = Executors.newFixedThreadPool(noOfCores);

        IntStream.range(0, 1000).forEach((int i) -> {
            Thread t = new Thread(new Runnable(){
                @Override
                public void run() {
                    try{
                        //Thread.sleep(Double.valueOf(Math.random() * 10 * 60).longValue());
                    }catch(Exception e){
                        System.out.println(e.getStackTrace());
                    }
                    System.out.println(i);
                    //print(Singleton.getInstance());
                }
            });
            ex.submit(t);
        });
        ex.shutdown();
    }
}
