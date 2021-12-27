package reactorproject.sec02;

import java.time.Duration;

import reactor.core.publisher.Flux;
import reactorproject.courseutil.Util;

public class Lecture08FluxInterval {

	public static void main(String[] args) {
		
		// it will publish items periodically
		Flux.interval(Duration.ofSeconds(1))
			.subscribe(Util.onNext());
		
		// to see things we need to block the main thread
		Util.sleepSeconds(5);
		
	}
	
	
	
}
