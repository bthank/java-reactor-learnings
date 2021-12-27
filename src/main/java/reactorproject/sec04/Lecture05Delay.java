package reactorproject.sec04;

import java.time.Duration;

import reactor.core.publisher.Flux;
import reactorproject.courseutil.Util;

public class Lecture05Delay {

	
	public static void main(String[] args) {
		
		Flux.range(1, 10)
			.log()
			.delayElements(Duration.ofSeconds(1))
			.subscribe(Util.subscriber());
			
		
		
		
	}
	
	
	
}
