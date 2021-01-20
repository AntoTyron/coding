package amazon.examples;

public class ThreadTest extends Thread {

	    //method where the thread execution will start 
	    public void run(){
	        //logic to execute in a thread    
	    	System.out.println("Inside run");
	    }

	    //let’s see how to start the threads
	    public static void main(String[] args){
	       Thread t1 = new ThreadTest();
	       Thread t2 = new ThreadTest();
	       t1.run();  //start the first thread. This calls the run() method.
	       //t2.start(); //this starts the 2nd thread. This calls the run() method.  
	    }
	

}
