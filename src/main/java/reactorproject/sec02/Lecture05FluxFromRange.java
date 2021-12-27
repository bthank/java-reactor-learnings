package reactorproject.sec02;

import reactor.core.publisher.Flux;
import reactorproject.courseutil.Util;

public class Lecture05FluxFromRange {

	
	public static void main(String[] args) {
		
		// this publisher will emit 10 items starting with 7 and incrementing each by 1
		Flux.range(7, 10)
			//.log()
			.subscribe(
						Util.onNext(),
						Util.onError(),
						Util.onComplete()
					);
		
		Flux.range(4, 10)
			.log()
			.map(i -> i + " " + Util.faker().name().fullName())
			.log()
			.subscribe(
					Util.onNext(),
					Util.onError(),
					Util.onComplete()
				);
		
	}
	
	
}
