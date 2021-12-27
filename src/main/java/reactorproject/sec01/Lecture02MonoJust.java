package reactorproject.sec01;

import reactor.core.publisher.Mono;

public class Lecture02MonoJust {

	public static void main(String[] args) {
		
		// this is a publisher
		Mono<Integer> mono = Mono.just(1);
		
		System.out.println(mono);
		
		// nothing happens until you subscribe to the publisher so that he emits the data
		mono.subscribe(i -> System.out.println("Received: " + i));
		
		
	}
	
	
}
