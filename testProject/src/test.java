import java.util.concurrent.atomic.AtomicLong;

public class test {
    public static void main(String[] args) {
        Num num=new Num();
        Thread[] threads=new Thread[10];
        for(int i=0;i<10;i++){
            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    //System.out.println(Thread.currentThread().getId()+"    "+SingletonHungary.getInstance().hashCode());
                    while (true)
                        System.out.println(Thread.currentThread().getName()+"   " +num.getAndIncrement());
                }
            });
        }
        for(int i=0;i<10;i++){
            threads[i].start();
        }
    }

}
class Num extends AtomicLong{
    Num(){
        super(10);
    }
}