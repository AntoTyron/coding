package thread.examples;

import java.lang.Thread;
import java.util.Arrays;

public class TestThreads {
	public static void main(String args[]) {
		try{
	TestThreads test = new TestThreads();
	Thread thread1 = new Thread(() -> {
		try {
			Thread.sleep(3000);
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	});
	thread1.start();
	Thread thread2 = new Thread( () -> {
	  try{
		System.out.println("State of Thread1" + thread1.getState());
		Thread.sleep(5000);
		System.out.println("State of Thread1 after sleep:"+ thread1.getState());
	  }catch(InterruptedException e) {
	    e.printStackTrace();
	  }
	});
	thread2.start();
	Thread[] tarray = new Thread[3];
	Thread.enumerate(tarray);
	Arrays.stream(tarray).forEach(y -> 
	System.out.println("Name:"+y.getName()+":ThreadState:"+y.getState()
			+":ThreadGroup:"+y.getThreadGroup()));
	try {
	thread1.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	System.out.println("Stateof the thread after join of thread1:"+thread2.getState());
	System.out.println("Current thread state:"+Thread.currentThread().getState());
	Thread.currentThread().interrupt();
	System.out.println("Current thread state:"+Thread.currentThread().getState());
	}catch(Exception e){
		System.out.println("Exception:"+Thread.currentThread().getState());
		
	}finally{
		System.out.println("Finally:"+Thread.currentThread().getState());
	}
	}
	
}
