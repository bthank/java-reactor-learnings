package reactorproject.sec03;

import reactor.core.publisher.Flux;
import reactorproject.courseutil.Util;

public class Lecture07FluxGenerateCounter {

	
	public static void main(String[] args) {
		
		Flux.generate(
						() -> 1,   // this is the initial state of a counter value equal to 1
						(counter, sink) -> { // this is the repeated bifunction
							String country = Util.faker().country().name();
							sink.next(country);
							if (counter > 9 || country.toLowerCase().equals("canada"))
								sink.complete();
									
							return counter + 1;
						}
				
				)
		.take(4)
		.subscribe(Util.subscriber());
		
		
		
	}
	
	
	
	
}
