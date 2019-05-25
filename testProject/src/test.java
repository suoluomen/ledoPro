public class test {
    public static void main(String[] args) {
        Thread[] threads=new Thread[10];
        for(int i=0;i<10;i++){
            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getId()+"    "+SingletonHungary.getInstance().hashCode());

                }
            });
        }
        for(int i=0;i<10;i++){
            threads[i].start();
        }
    }
}
