package reactorproject.sec03;

import reactor.core.publisher.Flux;
import reactorproject.courseutil.Util;

public class Lecture03FluxTake {

	
	public static void main(String[] args) {
		
		
		// map is an operator
		// filter is an operator
		
		Flux.range(1,10)
				.log()
				.take(3)  // take will accept only that many items
				.log()
				.subscribe(Util.subscriber());
		
	}
	
	
}
