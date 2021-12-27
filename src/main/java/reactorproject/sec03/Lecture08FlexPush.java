package reactorproject.sec03;

import reactor.core.publisher.Flux;
import reactorproject.courseutil.Util;
import reactorproject.sec03.helper.NameProducer;

public class Lecture08FlexPush {

	public static void main(String[] args) {
		
		NameProducer nameProducer = new NameProducer();
		
		//Note: 
		// - Flux.create() is thread safe 
		// - Flux.push() is not thread safe. It is only for a single thread producer
		
		
		Flux.push(nameProducer)
			.subscribe(Util.subscriber());
		
		
		Runnable runnable = () -> nameProducer.produce();
		
		for (int i = 0; i < 10; i++) {
			new Thread(runnable).start();
		}
		
		Util.sleepSeconds(2);
		
		
	}
}
