package reactorproject.sec02;

import reactor.core.publisher.Flux;
import reactorproject.courseutil.Util;

public class Lecture01FluxIntro {

	public static void main(String[] args) {
		
		
		// Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5);
		// Flux<Integer> flux = Flux.empty();
		Flux<Object> flux = Flux.just(1, 2, 3, "a", Util.faker().name().fullName());
		
		flux.subscribe(
				Util.onNext(), // next signal handler
				Util.onError(), // error signal handler
				Util.onComplete()); // completion signal handler
		
		
		
	}
	
	
}
