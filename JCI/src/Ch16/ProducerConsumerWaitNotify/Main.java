package Ch16.ProducerConsumerWaitNotify;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tT] [%4$-7s] %5$s %n");

        ProducerConsumer.startProducerConsumer();
        Thread.sleep(10 * 1000);
        ProducerConsumer.stopProducerConsumer();
	}

}
