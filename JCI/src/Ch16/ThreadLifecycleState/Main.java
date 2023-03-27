package Ch16.ThreadLifecycleState;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Run scenario for the NEW state");
        NewThread nt = new NewThread();
        nt.newThread();
        
        Thread.sleep(5000);
        
        // Run scenario for the RUNNABLE state
        System.out.println("Run scenario for the RUNNABLE state");        
        RunnableThread rt = new RunnableThread();
        rt.runnableThread();
        
        Thread.sleep(5000);
        
        // Run scenario for the WAITING state
        System.out.println("Run scenario for the WAITING state");        
        WaitingThread wt = new WaitingThread();
        wt.waitingThread();
        
        Thread.sleep(5000);
        
        // Run scenario for the TIME_WAITING state
        System.out.println("Run scenario for the TIME_WAITING state");        
        TimedWaitingThread twt = new TimedWaitingThread();
        twt.timedWaitingThread();
        
        Thread.sleep(5000);
        
        // Run scenario for the TERMINATED state
        System.out.println("Run scenario for the TERMINATED state");        
        TerminatedThread tt = new TerminatedThread();
        tt.terminatedThread();
        
        // Run scenario for the BLOCKED state
        System.out.println("Run scenario for the BLOCKED state");        
        BlockedThread bt = new BlockedThread();
        bt.blockedThread();               
	}

}
