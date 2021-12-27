package reactorproject.sec03;

import reactor.core.publisher.Flux;
import reactorproject.courseutil.Util;

public class Lecture04FluxCreateIssueFix {

	
	public static void main(String[] args) {
		
		// only 1 instance of FluxSink
		Flux.create(fluxSink -> {
					
			String country;
			
			do {
				country = Util.faker().country().name();
				System.out.println("Emitting : " + country);
				fluxSink.next(country);
			} while (!country.toLowerCase().equals("canada") && !fluxSink.isCancelled());
			fluxSink.complete();
			
			
		})
		.take(3)
		.subscribe(Util.subscriber());
		

	}
}
