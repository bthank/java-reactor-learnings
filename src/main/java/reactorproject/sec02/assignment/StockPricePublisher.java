package reactorproject.sec02.assignment;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

import reactor.core.publisher.Flux;
import reactorproject.courseutil.Util;

public class StockPricePublisher {

	
	public static Flux<Integer> getPrice() {
		
		// the stock price publisher
		AtomicInteger atomicInteger = new AtomicInteger(100);
		return Flux.interval(Duration.ofSeconds(1))
				.map(i -> atomicInteger.getAndAccumulate(
						Util.faker().random().nextInt(-5, 5),
						//(a, b) -> a + b
						Integer::sum
				));
		
	}
	
	
}
