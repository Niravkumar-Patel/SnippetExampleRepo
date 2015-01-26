package threadpoolexample;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TaskHolderQueue {

	private static BlockingQueue<Runnable> blockignQueue;
	private static int queueSize = 10;

	private TaskHolderQueue(){
	}

	public static BlockingQueue<Runnable> getTaskHolderQueue(){
		if(blockignQueue==null){
			blockignQueue = new ArrayBlockingQueue<Runnable>(queueSize);
			return blockignQueue;
		}else{
			return blockignQueue;
		}
	}	
}
