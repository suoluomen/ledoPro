public class testThreads {
    public static final String strA="a";
    public static final String strB="b";
    public static void main(String[] args) {
        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (strA){
                    System.out.println(Thread.currentThread().getName()+"获取a");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (strB){
                        System.out.println(Thread.currentThread().getName()+"获取b");
                    }
                }
            }
        });
        Thread threada =new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (strB){
                    System.out.println(Thread.currentThread().getName()+"获取b");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (strA){
                        System.out.println(Thread.currentThread().getName()+"获取a");
                    }
                }
            }
        });
        thread.start();
        threada.start();
    }
}
