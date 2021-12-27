package reactorproject.sec03;

import reactor.core.publisher.Flux;
import reactorproject.courseutil.Util;

public class Lecture01FluxCreate {

	public static void main(String[] args) {
		
		Flux.create(fluxSink -> {
			
//			fluxSink.next(1);
//			fluxSink.next(2);
//			fluxSink.complete();
			
			String country;
			
			do {
				country = Util.faker().country().name();
				fluxSink.next(country);
			} while (!country.toLowerCase().equals("canada"));
			
			fluxSink.complete();
			
			
		})
		.subscribe(Util.subscriber());
		
	}
	
	
}
