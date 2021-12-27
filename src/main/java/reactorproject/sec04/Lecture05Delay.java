package reactorproject.sec04;

import java.time.Duration;

import reactor.core.publisher.Flux;
import reactorproject.courseutil.Util;

public class Lecture05Delay {

	
	public static void main(String[] args) {
		
		System.setProperty("reactor.bufferSize.x", "9");
		
		Flux.range(1, 100)
			.log()
			.delayElements(Duration.ofSeconds(1))
			.subscribe(Util.subscriber());
			
		Util.sleepSeconds(60);
		
		
	}
	
	
	
}
