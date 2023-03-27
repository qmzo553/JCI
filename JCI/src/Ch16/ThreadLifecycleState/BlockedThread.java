package Ch16.ThreadLifecycleState;

public class BlockedThread {
	
	public void blockedThread() {
		Thread t1 = new Thread(new SyncBlockCode());
		Thread t2 = new Thread(new SyncBlockCode());
		
		t1.start();
		try {
			Thread.sleep(2000);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		
		t2.start();
		try {
			Thread.sleep(2000);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("Blocked thread t1 : " + t1.getState() + "(" + t1.getName() + ")");
		System.out.println("Blocked thread t2 : " + t2.getState() + "(" + t2.getName() + ")");
		
		System.exit(0);
	}
	
	private static class SyncBlockCode implements Runnable{
		
		@Override
		public void run() {
			System.out.println("Trhead" + Thread.currentThread().getName() + " is in run() method");
			syncMethod();
		}
		
		public static synchronized void syncMethod() {
			System.out.println("Thread " + Thread.currentThread().getName() + " is in syncMethod() method");
			while(true) {
				
			}
		}
	}
}
