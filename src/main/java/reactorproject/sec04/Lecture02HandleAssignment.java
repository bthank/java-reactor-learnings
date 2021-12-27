package reactorproject.sec04;

import reactor.core.publisher.Flux;
import reactorproject.courseutil.Util;

public class Lecture02HandleAssignment {

	
	public static void main(String[] args) {
		
		
		Flux.generate(synchronousSink -> synchronousSink.next(Util.faker().country().name()))
			.map(Object::toString)
			.handle((s, synchronousSink) -> {
				synchronousSink.next(s);
				if (s.toLowerCase().equals("canada"))
					synchronousSink.complete();
			})
			.subscribe(Util.subscriber());  // you need a subscriber in order to make the source emit data
		
		
		
		
	}
	
}
