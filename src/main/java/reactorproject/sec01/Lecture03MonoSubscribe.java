package reactorproject.sec01;

import reactor.core.publisher.Mono;
import reactorproject.courseutil.Util;

public class Lecture03MonoSubscribe {

	public static void main(String[] args) {
		
		// publisher
		Mono<Integer> mono = Mono.just("ball")
								.map(s -> s.length())
							//	.map(len -> len/0);
								.map(len -> len/1);
		
		// option 1
		// mono.subscribe();
		
		// option 2
		mono.subscribe(
				Util.onNext(),
				Util.onError(),
				Util.onComplete()

				
		);
		
		
	}
	
	
}
