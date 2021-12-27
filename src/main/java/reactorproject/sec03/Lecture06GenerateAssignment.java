package reactorproject.sec03;

import java.util.concurrent.atomic.AtomicInteger;

import reactor.core.publisher.Flux;
import reactorproject.courseutil.Util;

public class Lecture06GenerateAssignment {
	
	
	
	public static void main(String[] args) {
		
		// Rules to exit:
		// - if Canada, exit
		// - maximum emit up to 10 countries
		// - if subscriber cancels during the process, exit
		
		//AtomicInteger atomicInteger = new AtomicInteger(0);
		
		Flux.generate(synchronousSink -> { // using synchronousSink you are only allowed to emit a max of 1 item
			 
			//atomicInteger.incrementAndGet();
			String country = Util.faker().country().name();
			System.out.println("Emitting : " + country);

			synchronousSink.next(country);
			if (country.toLowerCase().equals("canada")) {
				synchronousSink.complete();
			}

		})

		.subscribe(Util.subscriber());
		
		
	}
}

