package Ch16.Deadlock;

public class Main {
	
	static class FirstThread implements Runnable {
		
		@Override
		public void run() {
			synchronized(Double.class) {
				System.out.println("Double.class locked by " + Thread.currentThread().getName());
				synchronized(Float.class) {
					System.out.println("Float.class locked by " + Thread.currentThread().getName());
				}
			}
		}
	}
	
	static class SecondThread implements Runnable {
		
		@Override
		public void run() {
			synchronized(Float.class) {
				System.out.println("Float.class locked by " + Thread.currentThread().getName());
				synchronized(Double.class) {
					System.out.println("Double.clas locked by " + Thread.currentThread().getName());
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new FirstThread(), "First-Thread").start();
		new Thread(new SecondThread(), "Second-Thread").start();
	}

}
