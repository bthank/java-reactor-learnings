package reactorproject.sec04;

import reactor.core.publisher.Flux;
import reactorproject.courseutil.Util;

public class Lecture01Handle {

	public static void main(String[] args) {
		
		// handle = filter + map
		Flux.range(1, 20)
				.handle((integer, synchronousSink) -> {
					
//					if (integer % 2 == 0) 
//						synchronousSink.next(integer); // this is more of a filter operation
//					else 
//						synchronousSink.next(integer + "a"); // this is a map operation
					
					
					if (integer == 7)
						synchronousSink.complete();
					else 
						synchronousSink.next(integer);
					
				})
				.subscribe(Util.subscriber());
		
		
	}
	
	
}
