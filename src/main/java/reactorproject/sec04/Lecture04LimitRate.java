package reactorproject.sec04;

import reactor.core.publisher.Flux;
import reactorproject.courseutil.Util;

public class Lecture04LimitRate {

	public static void main(String[] args) {
		
		
		Flux.range(1, 1000)
			.log()
			.limitRate(100, 99)
			.subscribe(Util.subscriber());
		
		
		
	}
	
	
}
