package reactorproject.sec02;

import reactor.core.publisher.Flux;

public class Lecture02MultipleSusbscribers {

	
	public static void main(String[] args) {
		
		
		
		Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4, 7, 19, 24);
		
		// we can have multiple subscribers to the Flux publisher (this is also applicable to Mono as well)
		
		Flux<Integer> evenFlux = integerFlux.filter(i -> i % 2 == 0);
		
		integerFlux
			.subscribe(i -> System.out.println("Subscriber 1 integer items: " + i));
		
		evenFlux
			.subscribe(i -> System.out.println("Subscriber 2 even items: " + i));
	}
}
