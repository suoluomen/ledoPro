import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SingletonHungary {
	private static SingletonHungary singletonHungary =null;
	//将构造器设置为private禁止通过new进行实例化
	private SingletonHungary() {
		
	}
	private static Lock lock=new ReentrantLock();
	public  static SingletonHungary getInstance() {

		if(singletonHungary==null){
				lock.lock();
				try {
					if (singletonHungary == null) {

							Thread.sleep(100);

						singletonHungary = new SingletonHungary();
					}
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally {
					lock.unlock();
				}
			}

		return singletonHungary;
	}
}
