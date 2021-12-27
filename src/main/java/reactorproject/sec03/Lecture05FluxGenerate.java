package reactorproject.sec03;

import reactor.core.publisher.Flux;
import reactorproject.courseutil.Util;

public class Lecture05FluxGenerate {

	public static void main(String[] args) {
		
		Flux.generate(synchronousSink -> { // using synchronousSink you are only allowed to emit a max of 1 item
			System.out.println("emitting");
			String country = Util.faker().country().name();
			System.out.println("Country is: " + country);
			if (country.toLowerCase().equals("canada")) {
				synchronousSink.complete();
			}
			synchronousSink.next(country);
			//synchronousSink.complete();  // the complete will terminate the generate loop
			//synchronousSink.error(new RuntimeException("error occurred"));
		})
		//
		//.take(2)
		.subscribe(Util.subscriber());
	}
}
