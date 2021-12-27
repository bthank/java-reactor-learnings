package reactorproject.sec02;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactorproject.courseutil.Util;
/*
 * How to convert a Mono to a Flux -> use Flux.from(mono)
 */
public class Lecture09FluxFromMono {

	public static void main(String[] args) {
		
	
		
		// Converting a Mono to a Flux
//		
//		Mono<String> mono = Mono.just("a");
//		
//		Flux<String> flux = Flux.from(mono);
//		
//		flux.subscribe(Util.onNext());
		
		
		
		// Converting a Flux to a Mono
		
		Flux.range(1, 10)
			.filter(i -> i > 3) // use a filter to get a value other than the 1st
			.next()
			.subscribe(
						Util.onNext(),
						Util.onError(),
						Util.onComplete()
					);
		
	}
	
	private static void doSomething(Flux<String> flux) {
		
		
		
	}
	
	
}
