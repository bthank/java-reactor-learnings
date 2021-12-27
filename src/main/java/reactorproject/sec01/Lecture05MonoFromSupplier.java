package reactorproject.sec01;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

import reactor.core.publisher.Mono;
import reactorproject.courseutil.Util;

public class Lecture05MonoFromSupplier {

	public static void main(String[] args) {
		
		// only use just when you have data already
		// Mono<String> mono = Mono.just(getName());
		
		Supplier<String> stringSupplier = () -> getName();
		// Mono<String> mono = Mono.fromSupplier(() -> getName());
		Mono<String> mono = Mono.fromSupplier(stringSupplier);
		mono.subscribe(
						Util.onNext()
						
				      );
		
		Callable<String> stringCallable = () -> getName();
		Mono.fromCallable(stringCallable)
				.subscribe(
						Util.onNext()
							);
		
		
	}
	
	private static String getName() {
		System.out.println("Generating name ...");
		return Util.faker().name().fullName();
	}
	
	
	
}
