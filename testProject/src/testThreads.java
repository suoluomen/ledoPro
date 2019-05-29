import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class testThreads {
    public static final String strA="a";
    public static final String strB="b";
    public static final Lock lock1=new ReentrantLock();
    public static final Lock lock2=new ReentrantLock();
    public static void main(String[] args) {
        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                lock1.lock();
                    System.out.println(Thread.currentThread().getName()+"获取a");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                lock2.lock();
                        System.out.println(Thread.currentThread().getName()+"获取b");
                lock2.unlock();
                lock1.unlock();
                }
        });
        Thread threada =new Thread(new Runnable() {
            @Override
            public void run() {
                while(lock2.tryLock()){
                    System.out.println(Thread.currentThread().getName()+"获取b");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                lock1.lock();
                        System.out.println(Thread.currentThread().getName()+"获取a");
                lock1.unlock();
                lock2.unlock();
                }

        });
        thread.start();
        threada.start();
    }
}
