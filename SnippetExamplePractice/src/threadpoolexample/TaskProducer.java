package threadpoolexample;

public class TaskProducer implements Runnable{

	@Override
	public void run() {
		System.out.println("PRODUCER STARTS");
		int numberOfTask = 3;
		while(numberOfTask>0){
			numberOfTask--;
			try {
				Task task = new Task();
				System.out.println("Task Produced and putting it in queue");
				TaskHolderQueue.getTaskHolderQueue().put(task);
				System.out.println("Task Placed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("PRODUCER DONE");
	}

}
