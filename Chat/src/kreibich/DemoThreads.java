package kreibich;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DemoThreads {
	
	
	static class Zaehlen implements Runnable{
		// Eig Thread hier schreibt man was der Thread machen soll
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()  +"zählt: " + i); // gibt vom jetztigen Thread den namen aus
				try {
					
					Thread.sleep(8000);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start -------");
		
		ExecutorService es = Executors.newFixedThreadPool(1);
		
		
		Thread t1 = new Thread(new Zaehlen());
		
		t1.setName("Erster");  // namen geben
		
		//t1.start(); startet Thread
		
		es.execute(t1);
		es.shutdown(); //wenn Threads fertig sind shutdown
		
		
		try {
			
		//	t1.join(); wartet bist Thread fertig ist
		// while damit es prüft ob der thread pool auch alle fertig sind 
		while(!es.awaitTermination(1, TimeUnit.SECONDS)) { 
			System.out.println("Thread braucht noch ");
		}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Ende ------");
		
		

	}

}
