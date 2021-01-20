package dailycodingexamples;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.*;
class JobScheduler{
	/*public Integer scheduleJob(Function<Integer,Integer> func, Integer milliSec)
			throws Exception{
		//while(true){
			Thread.sleep(milliSec);
			return func.apply(0);
						
		//}
	}
	
	public static void main(String args[]){
		Function<Integer,Integer> f = (a)->{try{System.out.println("Job running");
				Thread.sleep(1000);
				System.out.println("Job shutting down");
				return 1;
				}catch(Exception e){return 0;}
		};
		JobScheduler js = new JobScheduler();
		try{
			js.scheduleJob(f,3000);
		}catch(Exception e){System.out.println("Exception");}
	}*/
	
	static ScheduledExecutorService executor;
	
	public static void main(String args[]){		
		executor = Executors.newSingleThreadScheduledExecutor();		
		ScheduledFuture<?> future = solution(()-> System.out.println("Job starting"),1000);
		System.out.println("Is done "+ future.isDone());
		executor.shutdown();
		executor=null;
		
	}
	
	public static ScheduledFuture<?> solution(Runnable command, int milliSec){
		return executor.schedule(command, milliSec, TimeUnit.MILLISECONDS);
	}
}
