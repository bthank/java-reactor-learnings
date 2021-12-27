package reactorproject.sec01;

import reactor.core.publisher.Mono;
import reactorproject.courseutil.Util;

public class Lecture04MonoEmptyOrError {

	public static void main(String[] args) {
		
		// userRepository(1)
		// userRepository(2)
		userRepository(20)
				.subscribe(
						Util.onNext(),
						Util.onError(),
						Util.onComplete()
							);
	}
	
	
	// this is our publisher class
	private static Mono<String> userRepository(int userId) {
		
		// Id of 1
		if (userId == 1) {
			return Mono.just(Util.FAKER.name().firstName());
		} else if (userId == 2) {
			return Mono.empty();  // represents null
		} else {
			return Mono.error(new RuntimeException("Not in the allowed range"));
		}
		
		
	}
	
	
	
}
