package reactorproject.sec01;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactorproject.courseutil.Util;

public class Lecture06SupplierRefactoring {

	
	public static void main(String[] args) {
		
		getName();
		String name = getName()
			.subscribeOn(Schedulers.boundedElastic())
			// block() blocks the thread and gives you the result, however we should not use it in prod
			.block();
			/*.subscribe(
						Util.onNext(),
						Util.onError(),
						Util.onComplete()
					
						);*/
		System.out.println("Name is: " + name);
		
		getName();
		
		// to see the name, you have to block the main thread
		Util.sleepSeconds(4);
		
	}
	
	// this method acts like a publisher
	private static Mono<String> getName() {
		System.out.println("Entered getName method");
		return Mono.fromSupplier(() -> {
			System.out.println("Generating name ...");
			Util.sleepSeconds(3);
			return Util.faker().name().fullName();
		}).map(String::toUpperCase);
	}
	
	
}
