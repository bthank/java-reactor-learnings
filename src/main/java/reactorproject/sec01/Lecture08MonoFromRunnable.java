package reactorproject.sec01;

import reactor.core.publisher.Mono;
import reactorproject.courseutil.Util;

public class Lecture08MonoFromRunnable {

	public static void main(String[] args) {
		
		//Runnable runnable = () -> System.out.println("Mono from runnable");
		//Mono.fromRunnable(runnable)
		Mono.fromRunnable(timeConsumingProcess())
			.subscribe(Util.onNext(),
					   Util.onError(),
					   //Util.onComplete());
					   () -> {
						  System.out.println("Process is done.  Sending emails or some sort of business logic ..."); 
					   });
	}
	
	private static Runnable timeConsumingProcess() {
		return () -> {
			Util.sleepSeconds(3);
			System.out.println("Time consuming operation completed");
		};
	}
	
}
