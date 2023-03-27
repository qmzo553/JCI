package Ch16.CancelThread;

import java.util.concurrent.*;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		RandomList rl = new RandomList();

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executor.execute(rl);
        }

        Thread.sleep(100);
        rl.cancel();

        System.out.println(rl.getRandoms());

        executor.shutdown();
        executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
	}

}
