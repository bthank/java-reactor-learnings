package reactorproject.sec03;

import reactor.core.publisher.Flux;
import reactorproject.courseutil.Util;
import reactorproject.sec03.helper.NameProducer;

public class Lecture02FluxCreateRefactoring {

	public static void main(String[] args) {
		
		NameProducer nameProducer = new NameProducer();
		
		Flux.create(nameProducer)
			.subscribe(Util.subscriber());
		
		
		Runnable runnable = () -> nameProducer.produce();
		
		for (int i = 0; i < 10; i++) {
			new Thread(runnable).start();
		}
		
		Util.sleepSeconds(2);
		
	}
}
