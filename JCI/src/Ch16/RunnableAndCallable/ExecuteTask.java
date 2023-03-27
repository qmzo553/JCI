package Ch16.RunnableAndCallable;

import java.util.concurrent.*;
import java.util.logging.Logger;

public class ExecuteTask {
	
	private static final Logger logger = Logger.getLogger(ExecuteTask.class.getName());
	
	public void runnableExample() {
		
		Thread t = new Thread(() -> {
			System.out.println("Entered Runnable");
			
			try {
				Thread.sleep(2000);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
				logger.severe(() -> "Exception : " + ex);
			}
		});
		t.start();
	}
	
	public void callableExample() throws InterruptedException, ExecutionException {
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		Callable<String> callable = () -> {
			
			System.out.println("Entered Callable");
			Thread.sleep(2000);
			
			return "Hello from Callable";
		};
		
		System.out.println("Submitting Callable");
		Future<String> future = executorService.submit(callable);
		
		System.out.println("Do something else while callable is getting executed");
		System.out.println("Retriecve the result of the future");
		
		String result = future.get();
		
		System.out.println(result);
		
		executorService.shutdown();
	}
}
