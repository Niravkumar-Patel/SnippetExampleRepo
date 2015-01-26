package threadpoolexample;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TaskConsumer implements Runnable {

	@Override
	public void run(){
		
		ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 10, 100, TimeUnit.SECONDS, TaskHolderQueue.getTaskHolderQueue());
		
		
		System.out.println("CONSUMER STARTS");
		int i = 3;
		while(i>0){
			i--;
			try {
				tpe.execute(TaskHolderQueue.getTaskHolderQueue().take());
				System.out.println("Task consumed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
		tpe.shutdown();
		System.out.println("CONSUMER DONE");
	}
}
